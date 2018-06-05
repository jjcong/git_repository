package thread.test.threadpool;
import java.util.Arrays;
import java.util.concurrent.*;

public class CountDownLatchTest {

    public static void main(String[] args) {

        int count = 10;
        final CountDownLatch latch = new CountDownLatch(count);
        int[] datas = new int[100];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = (int) (Math.random() * 100 + 1);
        }
        int step = datas.length / count;

        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10,
                60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(count));
        for (int i = 0; i < count; i++) {
            int start = i * step;
            int end = (i + 1) * step;

            if (i == count - 1) {
                end = datas.length;
            }

            pool.execute(new MyRunnable(latch, datas, start, end));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }

        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + " ");
            if (i % 10 == 9) {
                System.out.println();
            }
        }
    }
}

class MyRunnable implements Runnable {

    private CountDownLatch latch;
    private int[] datas;
    private int start;
    private int end;

    MyRunnable(CountDownLatch latch, int[] datas, int start, int end) {

        this.latch = latch;
        this.datas = datas;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        //  synchronized (datas){
        Arrays.sort(datas, start, end);
        System.out.println(start + "----" + end);
        System.out.println();
        for (int i = start; i < end; i++) {
            System.out.print(datas[i] + " ");
        }
        System.out.println();
        System.out.println("被调用");
        // }
        latch.countDown();
    }
}