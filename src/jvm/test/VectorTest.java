package jvm.test;

import java.util.Vector;

/**
 * 测试Vector的线程安全性
 *
 * @author  j_cong
 * @date    2018/03/04
 * @version V1.0
 */
public class VectorTest {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {


        while (true) {
            for (int i = 0; i < 100; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }

                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));
                        }
                    }

                }
            });

            removeThread.start();
            printThread.start();

            while (Thread.activeCount() > 20);

        }

    }
}
