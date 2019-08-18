package thread.test;
/**
 * 两个线程交替打印，线程1打印奇数，线程2打印偶数
 *
 * @author  j_cong
 * @date    2018/10/18
 * @version V1.0
 */
public class ThreadTurn {

    Object obj = new Object();
    Boolean flag = true;

    class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 100; i = i + 2) {
                    System.out.println("A线程---->" + i);
                    obj.notify();
                    if(flag) {
                        flag = false;
                        try {
                            obj.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 1; i < 100; i = i + 2) {
                    System.out.println("B线程---->" + i);
                    obj.notify();
                    if(!flag) {
                        flag = true;
                        try {
                            obj.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void start(){
        new Thread1().start();
        new Thread2().start();
    }

    public static void main(String[] args) {
        ThreadTurn test = new ThreadTurn();
        test.start();
    }
}
