package thread.test;

import java.util.concurrent.Semaphore;

/**
 * @ Author:  j_cong
 * @ Date:    2017-10-25
 * @ Version: V1.0
 * @ Desc:    Semaphore信号量测试，模拟停车厂
 */
public class SemaphoreTest {

    static class Parking {

        //信号量
        private Semaphore semaphore;

        Parking(int count) {
            semaphore = new Semaphore(count);
        }

        private void park() {

            try {
                //获取信号量
                semaphore.acquire();
                long time =(long) (Math.random() * 10);

                System.out.println(Thread.currentThread().getName()
                        + "进入停车场，停车" + time +"秒...");
                Thread.sleep(time);
                System.out.println(Thread.currentThread().getName()
                        + "开出停车厂...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }

        }

    }

    static class Car extends Thread {
        Parking parking;

        Car(Parking parking) {
            this.parking = parking;
        }

        @Override
        public void run() {
            parking.park(); //进入停车厂
        }
    }

    public static void main(String[] args) {

        Parking parking = new Parking(3);

        for (int i = 0; i < 5; i++) {
            new Car(parking).start();
        }
    }
}
