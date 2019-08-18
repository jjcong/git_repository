package algorithm.test.exercise.ProducerConsumerModel;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者消费者模型，使用BlockingQueue实现
 * 
 * @author  j_cong
 * @date    2018/08/29
 * @version V1.0
 */
public class ProducerConsuerByBQ {

    final BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
    private static Integer count = 0;


    public static void main(String[] args) {
        ProducerConsuerByBQ test1 = new ProducerConsuerByBQ();

        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
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
                    blockingQueue.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前共有："
                            + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前共有："
                            + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
