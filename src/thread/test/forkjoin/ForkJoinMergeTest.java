package thread.test.forkjoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinMergeTest {
    private static int MAX = 10000000;
    private static int[] ints = new int[MAX];

    static {
        Random random = new Random();
        for (int i = 1; i <= MAX; i++) {
            ints[i - 1] = random.nextInt(1000000);
        }
    }

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        MyTask task = new MyTask(ints);
        ForkJoinTask<int[]> taskResult = pool.submit(task);
        try {
            taskResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("耗时=" + (endTime - beginTime) + "ms");
    }

    static class MyTask extends RecursiveTask<int[]> {
        private int[] src;

        public MyTask(int[] source) {
            this.src = source;
        }
        @Override
        protected int[] compute() {
            int srcLen = src.length;
            if (srcLen > 2) {
                int midIndex = srcLen / 2;
                MyTask task1 = new MyTask(Arrays.copyOf(src, midIndex));
                task1.fork();
                MyTask task2 = new MyTask(Arrays.copyOfRange(src, midIndex, srcLen));
                task2.fork();

                int[] res1 = task1.join();
                int[] res2 = task2.join();
                int[] merger = joinInts(res1, res2);

                return merger;
            } else {
                if (srcLen == 1 || src[0] <= src[1]) {
                    return src;
                } else {
                    int[] tmp = new int[srcLen];
                    tmp[0] = src[1];
                    tmp[1] = src[0];
                    return tmp;
                }
            }
        }
    }


    private  static int[] joinInts(int[] arr1, int[] arr2) {
        int aLen = arr1.length;
        int bLen = arr2.length;
        int[] tmp = new int[aLen + bLen];
        int k = 0;
        int i = 0;
        int j = 0;

        while (i < aLen && j < bLen) {
            tmp[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }
        while (i < aLen) {
            tmp[k++] = arr1[i++];
        }

        while (j < bLen) {
            tmp[k++] = arr2[j++];
        }
        return tmp;
    }
}
