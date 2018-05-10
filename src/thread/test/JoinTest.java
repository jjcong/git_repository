package thread.test;

import design.pattern.adapter.methodadapter.Source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 假设有两个线程，一个是线程 A，另一个是线程 B，A 先打印123，然后B再打印123
 * 
 * @author  j_cong
 * @date    2018/04/30
 * @version V1.0
 */
public class JoinTest {

    public static void main(String[] args) {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                print(Thread.currentThread().getName());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1等待线程0");
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
