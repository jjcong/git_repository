package thread.test;
/**
 * 假设有两个线程，一个是线程 A，另一个是线程 B，两个线程分别依次打印 1-3 三个数字即可
 *
 * @author  j_cong
 * @date    2018/04/30
 * @version V1.0
 */
public class PrintInTurnTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                print(Thread.currentThread().getName());

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                print(Thread.currentThread().getName());

            }
        });

        thread1.start();
        thread2.start();
    }

    public  static void print(String threadName) {
        int cnt = 0;

        while (cnt++ < 3) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadName + " print " + cnt);
        }
    }

}
