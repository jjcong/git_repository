package thread.test.threadpool;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ Author:  j_cong
 * @ Date:    2017-11-23
 * @ Version: V1.0.0
 * @ Desc:    自定义线程池测试
 */
public class MyThreadPoolTest {

    private  static int produceTaskSleepTime = 2;
    private  static int produceTaskMaxNumber = 10;

    public static void main(String[] args) {
        //构造一个线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4,
                3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 1; i <= produceTaskMaxNumber; i++) {
            try {
                //产生一个任务，并将其加入到线程池
                String task = "task@" + i;
                System.out.println("put" + task);
                //便于观察，等待一段时间
                Thread.sleep(produceTaskSleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 线程池执行的任务
     */
    class ThreadPoolTask implements Runnable, Serializable {

        private static final long serialVersionUID = 3448768967543977778L;
        //保存任务所需的数据
        private Object threadPoolTaskData;

        ThreadPoolTask(Object tasks) {
            this.threadPoolTaskData = tasks;
        }
        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName());
            System.out.println("start..." + threadPoolTaskData);

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            threadPoolTaskData = null;
        }

        public Object getTask() {
            return  this.threadPoolTaskData;
        }
    }


}
