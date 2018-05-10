package thread.test;
/**
 * 两个线程，循环打印A,B，10次
 *
 * @author  j_cong
 * @date    2018/04/30
 * @version V1.0
 */
public class PrintTest {

    static  Object obj = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + " print  A" );

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }
}
