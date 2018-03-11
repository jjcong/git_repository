package thread.test;

/**
 * volatile变量自增运算测试
 *
 * @author  j_cong
 * @date    2018/01/07
 * @version V1.0
 */
public class VolatileTest {

    private static volatile int race = 0;

    private static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        //等待所有累加线程都结束
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
