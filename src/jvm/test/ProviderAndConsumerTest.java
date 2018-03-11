package jvm.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者-消费者模型，使用阻塞队列实现
 *
 * @author  j_cong
 * @date    2018/03/08
 * @version V1.0
 */
public class ProviderAndConsumerTest {

    public static void main(String[] args) {

        //如果不设置初始容量，则默认为Integer.MAX_VALUE（2^31-1）
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(8);

        Consumer consumer = new Consumer(queue);
        Provider provider = new Provider(queue);

        Executor executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executor.execute(consumer);
            executor.execute(provider);

//            new Thread(provider, "provider" + (i + 1)).start();
//            new Thread(consumer, "consumer" + (i + 1)).start();
        }
    }
}
