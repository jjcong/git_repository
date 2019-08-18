package algorithm.test.exercise.ProducerConsumerModel;
/**
 * 生产者消费者模型，使用wait()、notifyAll()
 * 
 * @author  j_cong
 * @date    2018/08/29
 * @version V1.0
 */
public class ProducerConsumerBySyn {

    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";

    public static void main(String[] args) {
        ProducerConsumerBySyn test1 = new ProducerConsumerBySyn();

        for (int i = 0; i < 100; i++) {
            new Thread(test1.new Producer()).start();
            new Thread(test1.new Consumer()).start();
        }

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
                synchronized (LOCK) {
                    while (FULL.equals(count)) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前共有："
                        + count);
                    LOCK.notifyAll();

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
                synchronized (LOCK) {
                    while (0 == count) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前共有："
                            + count);
                    LOCK.notifyAll();

                }
            }

        }
    }
}
