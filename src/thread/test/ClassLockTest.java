package thread.test;
/**
 * 测试锁住类.class，其他非synchronized方法可以访问吗？
 * 
 * @author  j_cong
 * @date    2018/04/29
 * @version V1.0
 */
public class ClassLockTest {

    public static void main(String[] args) {
        new Thread5().start();
        new Thread6().start();

    }

    public static void sayHello() {
        synchronized (ClassLockTest.class) {
            System.out.println(Thread.currentThread().getName() + " say hello!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void sayWorld() {
            System.out.println(Thread.currentThread().getName() + " say world!");

    }

    public static class Thread5 extends Thread {

        @Override
        public void run() {
            ClassLockTest.sayHello();
        }
    }

    public static class Thread6 extends Thread {

        @Override
        public void run() {
            ClassLockTest.sayWorld();
        }
    }

}
