package thread.test.threadpool;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 判断线程池中的任务是否全部完成
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/04/19
 */
public class ThreadsIsDone {

    public static void main(String[] args) {
        //创建一个10个线程的线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        for (int i = 0; i < 10; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程:" + Thread.currentThread().getName() + ",打印随机数:" + new Random().nextInt(1000));
                }
            });
        }
        System.out.println("pool.getTaskCount():" + pool.getTaskCount());
        System.out.println("pool.getCompletedTaskCount():" + pool.getCompletedTaskCount());
        boolean allThreadsIsDone = pool.getTaskCount() == pool.getCompletedTaskCount();
        System.out.println(allThreadsIsDone);
        if (allThreadsIsDone) {
            System.out.println("全部执行完成");
        }
        while (!allThreadsIsDone) {
            allThreadsIsDone = pool.getTaskCount() == pool.getCompletedTaskCount();
            if (allThreadsIsDone) {
                System.out.println("全部执行完成");
            }
        }


    }
}
