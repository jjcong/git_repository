package thread.test;

import java.util.concurrent.CountDownLatch;

/**
 * @ Author:  j_cong
 * @ Date:    2017-10-25
 * @ Version: V1.0
 * @ Desc:    CountDownLatch测试，开会案例
 *            老板进入会议室等待5个人全部到齐才会开会，所以这里有
 *            两个线程:老板等待开会线程、员工到达会议室
 */
public class CountDownLatchTest {

    private static final CountDownLatch countDownLatch = new CountDownLatch(5);

    /*
    Boss线程，等待员工到达开会
     */
    static class BossThread extends Thread {
        @Override
        public void run() {
            System.out.println("Boss在会议室等待，总共有：" + countDownLatch.getCount()
                + "个人开会");
            try {
                //等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("所有人都到齐了，开会吧！");
        }
    }

    /*
    员工线程
     */
    static class EmployeeThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "到达会议室...");

            //员工到达会议室，count -1
            countDownLatch.countDown();
        }
    }


    public static void main(String[] args) {
        new BossThread().start();

        for (int i = 0; i < 5; i++) {
            new EmployeeThread().start();
        }
    }

}
