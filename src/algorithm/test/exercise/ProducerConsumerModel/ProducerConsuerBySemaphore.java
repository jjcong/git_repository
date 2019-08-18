package algorithm.test.exercise.ProducerConsumerModel;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * 生产者消费者模型，使用Semaphore实现
 * 
 * @author  j_cong
 * @date    2018/08/29
 * @version V1.0
 */
public class ProducerConsuerBySemaphore {

    final BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
    private static Integer count = 0;
    final Semaphore notFull = new Semaphore(10);
    final Semaphore notEmpty = new Semaphore(0);
    final Semaphore mutex = new Semaphore(1);



    public static void main(String[] args) {
        ProducerConsuerBySemaphore test1 = new ProducerConsuerBySemaphore();
        for (int i = 0; i < 4 ; i++) {
            new Thread(test1.new Producer()).start();
            new Thread(test1.new Consumer()).start();
        }
    }



    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    notFull.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前共有："
                            + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notEmpty.release();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    notEmpty.acquire();
                    notFull.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前共有："
                            + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notFull.release();
                }
            }
        }
    }
}
