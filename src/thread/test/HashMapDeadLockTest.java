package thread.test;

import java.util.HashMap;

/**
 * 扩容时，HashMap可能引发死锁,根本原因在于transfer链表复制中
 *
 * @author  j_cong
 * @date    2018/05/01
 * @version V1.0
 */
public class HashMapDeadLockTest {

    private HashMap<Integer, Integer> map = new HashMap<>();

    public HashMapDeadLockTest() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.put(Integer.valueOf((int)Math.random()), i);
                }
                System.out.println("t1 is over!");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.put(Integer.valueOf((int)Math.random()), i);
                }
                System.out.println("t2 is over!");
            }
        });
        t1.start();
        t2.start();

    }

    public static void main(String[] args) {

        new HashMapDeadLockTest();
    }
}
