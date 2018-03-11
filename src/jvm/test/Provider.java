package jvm.test;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者-消费者模型，使用阻塞队列实现
 *
 * @author  j_cong
 * @date    2018/03/08
 * @version V1.0
 */
public class Provider implements Runnable {

    BlockingQueue<String> queue;

    public Provider(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String tmp = "A Provider, 生产线程：" + Thread.currentThread().getName();
        System.out.println("I have made a product:" + Thread.currentThread().getName());

        try {
            queue.put(tmp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
