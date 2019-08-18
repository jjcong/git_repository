package algorithm.test.exercise.笔试真题.美团;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RaceByCountDownLatch {
    static CountDownLatch p1 = new CountDownLatch(1);
    static CountDownLatch p2 = new CountDownLatch(10);
    static CountDownLatch f1 = new CountDownLatch(1);
    static CountDownLatch f2 = new CountDownLatch(10);

    public static void main(String args[]) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println("选手们进场");
        System.out.println("裁判喊准备");
        p1.countDown();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            service.submit(new Runnable() {

                @Override
                public void run() {
                    try {
                        p1.await();
                        System.out.println("运动员" + j + "开始准备");

                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        System.out.println("运动员" + j + "准备完成");
                        p2.countDown();
                    }
                    try {
                        f1.await();
                        long time = (long) (Math.random() * 1000);
                        Thread.sleep(time);

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        System.out.println("运动员" + j + "到达终点");
                        f2.countDown();
                    }
                }
            });
        }

        p2.await();
        System.out.println("裁判喊开始");
        f1.countDown();
        f2.await();
        System.out.println("比赛结束");

        service.shutdown();
    }

}
