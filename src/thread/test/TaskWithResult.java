package thread.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ Author:  j_cong
 * @ Date:    2017-11-23
 * @ Version: V1.0.0
 * @ Desc:    缓冲线程池实例-submit运行
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {
        System.out.println("call()方法被自动调用，干活！！！" + Thread.currentThread().getName());

        for (int i = 999999; i > 0; i--);
            return "call()方法被自动调用，任务的结果是：" + id + "  " + Thread.currentThread().getName();


    }


        public static void main(String[] args) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            List<Future<String>> resultList = new ArrayList<>();

            for (int i = 0; i < 10; i++) {

                Future<String> future = executorService.submit(new TaskWithResult(i));
                resultList.add(future);
            }
            executorService.shutdown();

            for (Future<String> fs : resultList) {
                try {
                    System.out.println(fs.get()); //打印各个线程执行的结果
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } finally {

                }
            }
        }

}
