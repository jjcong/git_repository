package thread.test;

import java.util.concurrent.CyclicBarrier;

/**
 * @ Author:  j_cong
 * @ Date:    2017-10-23
 * @ Version: V1.0
 * @ Desc:    线程等待到一定条件后才会继续进行
 */
public class CyclicBarrierTest {

    private static CyclicBarrier barrier;

    static class ThreadTest extends Thread {
        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + "到达...");

            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完成...");
        }
    }

    public static void main(String[] args) {

        barrier = new CyclicBarrier(6, new Runnable() {
            @Override
            public void run() {
                System.out.println("执行CyclicBarrier中的任务...");
            }
        });

        for (int i = 0; i < 6; i++) {
            new ThreadTest().start();
        }
    }
}
