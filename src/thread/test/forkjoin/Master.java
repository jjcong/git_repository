package thread.test.forkjoin;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CountDownLatch;

/**
 * 模拟forkjoin 分布式计算
 * Master为控制器，用于接收客户端发送过来的任务和分配任务到各个worker，
 * 每个worker计算后把结果返回给Master
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/07/24
 */
public class Master {
    //1、一个装任务的容器
    private ConcurrentLinkedDeque<Task> tasks = new ConcurrentLinkedDeque<>();
    //2、一个装Worker的容器，其中worker是一个线程
    private Map<String, Thread> works = new HashMap<>();
    //3、一个装运算结果的容器
    private ConcurrentHashMap<String, Object> result = new ConcurrentHashMap<>();
    // 统计任务完成情况
    private final CountDownLatch workComplete;

    public Master(Worker worker, int taskCount, CountDownLatch countDownLatch) {
        //每一个worker都必须要有master的引用，用于分配任务
        worker.setResult(result);
        //把结果给work，用于计算完后返回给master
        this.workComplete = countDownLatch;
        worker.setWorkComplete(workComplete);

        for (int i = 0; i < taskCount; i++) {
            /**
             * key表示每一个worker的名字，value表示线程执行对象,
             * 这里创建一个对象即可，不需要创建十个对象，只需创建十个线程即可
             */
            works.put("子节点" + i, new Thread(worker));
        }
    }


    public void summit(Task task) {
        tasks.add(task);
    }

    public void execute() {
        for (Map.Entry<String, Thread> mc : works.entrySet()) {
            System.out.println(mc.getKey() + "开始执行。。。。。。");
            mc.getValue().start();
        }
    }

    public int getResult() {
        int res = 0;
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            res += (Integer) entry.getValue();
        }
        return res;
    }


    static class Worker implements Runnable {

        private ConcurrentLinkedDeque<Task> tasks;
        private ConcurrentHashMap<String, Object> result;
        private CountDownLatch workComplete;


        @Override
        public void run() {

            Integer output = null;
            while (!tasks.isEmpty()) {
                Task input = tasks.poll();
                output = (Integer) handler(input);
                result.put(String.valueOf(input.getId()), output);
                workComplete.countDown();
            }
        }

        public Object handler(Task input) {
            Object output = null;
            try {
                System.out.println(input.getName() + ":执行任务中。。。。。");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            output = input.getPrice();

            return output;
        }

        public ConcurrentLinkedDeque<Task> getTasks() {
            return tasks;
        }

        public void setTasks(ConcurrentLinkedDeque<Task> tasks) {
            this.tasks = tasks;
        }

        public ConcurrentHashMap<String, Object> getResult() {
            return result;
        }

        public void setResult(ConcurrentHashMap<String, Object> result) {
            this.result = result;
        }

        public CountDownLatch getWorkComplete() {
            return workComplete;
        }

        public void setWorkComplete(CountDownLatch workComplete) {
            this.workComplete = workComplete;
        }
    }


    public static void main(String[] args) {
        int allTaskCount = 100;
        CountDownLatch countDownLatch = new CountDownLatch(allTaskCount);
        Master master = new Master(new Worker(), 100, countDownLatch);
        Random random = new Random();

        for (int i = 0; i <= allTaskCount; i++) {
            Task task = new Task();
            task.setId(i);
            task.setName("任务" + i);
            task.setPrice(random.nextInt(1000));

            master.summit(task);
        }

        master.execute();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("总结果为：" + master.getResult());
    }
}
