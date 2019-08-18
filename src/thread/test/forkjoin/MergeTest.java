package thread.test.forkjoin;

import java.util.Arrays;
import java.util.Random;

public class MergeTest {
    private static int MAX = 10000;
    private static int[] ints = new int[MAX];

    static {
        Random random = new Random();
        for (int i = 1; i <= MAX; i++) {
            ints[i - 1] = random.nextInt(1000000);
        }
    }

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        int[] results = forkits(ints);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时=" + (endTime - beginTime) + "ms");
    }

    private static int[] forkits(int[] src) {
        int srcLen = src.length;
        if (srcLen > 2) {
            int midIndex = srcLen / 2;
            int[] res1 = forkits(Arrays.copyOf(src, midIndex));
            int[] res2 = forkits(Arrays.copyOfRange(src, midIndex, srcLen));
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
