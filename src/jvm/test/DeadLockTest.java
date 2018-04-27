package jvm.test;
/**
 * 死锁cehsi
 *
 * @author  j_cong
 * @date    2018/04/23
 * @version V1.0
 */
public class DeadLockTest implements Runnable {

    int a;
    int b;

    private DeadLockTest (int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }


    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new DeadLockTest(1, 2)).start();

            new Thread(new DeadLockTest(2, 1)).start();

        }
    }
}
