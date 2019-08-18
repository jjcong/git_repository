package thread.test;

import org.junit.experimental.theories.Theory;

import java.util.concurrent.*;

public class Test {

    private static CountDownLatch latch = null;

    public static void main(String[] args) {
        Test test = new Test();
        latch = new CountDownLatch(3);
        int res = 0;

        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(new SubThead(1));
        exec.submit(new SubThead(2));
        exec.submit(new SubThead(3));

    }

    private static int getMultiResult(int num) {

        int res = 1;

        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    static class SubThead implements Callable {
        private int num;
        private int res;
        private SubThead(int num) {
            this.num = num;
        }


        @Override
        public Object call() throws Exception {
            res = getMultiResult(num);
            latch.countDown();

            return res;
        }
    }

}
