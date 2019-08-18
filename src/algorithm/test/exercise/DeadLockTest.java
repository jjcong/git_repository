package algorithm.test.exercise;
/**
 * synchronized导致的死锁
 * 
 * @author  j_cong
 * @date    2018/09/01
 * @version V1.0
 */
public class DeadLockTest {

    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void main(String[] args) {
        new DeadLockTest().deadLock();
    }


    private void deadLock() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "获得lockA锁");
                        //如果当且仅当当前线程拥有某个具体对象的锁,返回true
                        System.out.println(Thread.holdsLock(lockA));
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName()+" after sleep 500ms!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (lockB) {
                        System.out.println(Thread.currentThread().getName() + "获得lockB锁");

                    }
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "获得lockB锁");
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName()+" after sleep 500ms!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (lockA) {
                        System.out.println(Thread.currentThread().getName() + "获得lockA锁");

                    }
                }
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}
