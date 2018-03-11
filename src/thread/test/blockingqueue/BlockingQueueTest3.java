package thread.test.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Author:  j_cong
 * @ Date:    2017-11-24
 * @ Version: V1.0.0
 * @ Desc:    生产者、消费者模型，阻塞队列实现
 */
class StoreHouse {
    //仓储的容量
    private int capacity;
    //仓储的载体
    private BlockingQueue<Object> blockingQueue;
    //当前个数
    private AtomicInteger curNum = new AtomicInteger(0);

    public StoreHouse(int capacity) {
        this.capacity = capacity;
        this.blockingQueue = new ArrayBlockingQueue<>(capacity);
    }


    /**
     * 生产的方法
     * @param num  可以生产的数量
     */
    public void produce(int num) {
        while (num + curNum.get() > capacity) {
            System.out.println("【仓库已无法再生产：" + num + "个商品】" +
                    "当前仓库产品数量：" + curNum.get());
        }
        System.out.println("【仓库还未满，生产：" + num + "个商品没有问题】" +
                "当前仓库产品数量：" + blockingQueue.size());
        for (int i = 0; i < num; i++) {
            blockingQueue.add(new Object());
            curNum.incrementAndGet();
        }
    }

        /**
         * 消费的方法
         * @param num  可以消费的数量
         *
         */
    public void consumer(int num) {
        while (num > curNum.get()) {
            System.out.println("【仓库没有：" + num + "个商品可消费】" +
                    "当前仓库产品数量：" + blockingQueue.size());
        }
        System.out.println("【仓库有：" + num + "个商品可消费】" +
                "当前仓库产品数量：" + blockingQueue.size());
        for (int i = 0; i < num; i++) {
            try {
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            curNum.decrementAndGet();
        }
    }
}
class ProducerThread extends Thread {
    /**
     * 每次生产的产品数量
     */
    private int num;

    /**
     * 所在放置的仓库
     */
    private StoreHouse storeHouse;

    public ProducerThread(StoreHouse storeHouse, int num) {
        this.num = num;
        this.storeHouse = storeHouse;
    }
    @Override
    public void run() {
        storeHouse.produce(num);
    }
}

class ConsumerThread extends Thread {

    /**
     * 每次生产的产品数量
     */
    private int num;

    /**
     * 所在放置的仓库
     */
    private StoreHouse storeHouse;

    public ConsumerThread(StoreHouse storeHouse, int num) {
        this.num = num;
        this.storeHouse = storeHouse;
    }
    @Override
    public void run() {
        storeHouse.consumer(num);
    }
}

public class BlockingQueueTest3 {

    public static void main(String[] args) {
        //仓库对象
        StoreHouse storeHouse = new StoreHouse(1000);

        //生产者对象
        ProducerThread producer1 = new ProducerThread(storeHouse, 200);
        ProducerThread producer2 = new ProducerThread(storeHouse, 200);
        ProducerThread producer3 = new ProducerThread(storeHouse, 100);
        ProducerThread producer4 = new ProducerThread(storeHouse, 300);
        ProducerThread producer5 = new ProducerThread(storeHouse, 400);
        ProducerThread producer6 = new ProducerThread(storeHouse, 200);
        ProducerThread producer7 = new ProducerThread(storeHouse, 500);

        //消费者对象
        ConsumerThread consumer1 = new ConsumerThread(storeHouse, 500);
        ConsumerThread consumer2 = new ConsumerThread(storeHouse, 200);
        ConsumerThread consumer3 = new ConsumerThread(storeHouse, 800);

        consumer1.start();
        consumer2.start();
        consumer3.start();

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        producer6.start();
        producer7.start();

    }
}
