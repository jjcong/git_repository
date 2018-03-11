package jvm.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile在并发条件下的测试（非原子性）
 *
 * @author  j_cong
 * @date    2018/03/03
 * @version V1.0
 */
public class VolatileTest {

    public static AtomicInteger race = new AtomicInteger(0);
//    public volatile static int race = 0;

    public static void increase() {

        race.addAndGet(1);

    }

    private static final int THREAD_COUNT = 100;

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        //等待所有的线程执行结束
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(race);
        //获取结束时间
        long endTime = System.currentTimeMillis();
        //输出程序运行时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

}
