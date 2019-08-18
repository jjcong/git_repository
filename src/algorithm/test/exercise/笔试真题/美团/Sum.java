package algorithm.test.exercise.笔试真题.美团;
/**
 * 使用CountDownLatch计算1! + 2! + 3! + 4! + 5!
 *
 * @author  j_cong
 * @date    2018/09/03
 * @version V1.0
 */
import algorithm.test.exercise.JdkDynamicProxy.MyInvocationHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sum {
    static CountDownLatch p2=new CountDownLatch(1);
    static CountDownLatch p3=new CountDownLatch(1);
    static CountDownLatch p4=new CountDownLatch(1);
    static CountDownLatch p5=new CountDownLatch(1);
    static CountDownLatch p6=new CountDownLatch(1);
    static List<CountDownLatch> latchList = new ArrayList<>(5);

    static int sum=0;
    static int  cur =1;
    static int G=1;

    private Sum() {
        for (CountDownLatch latch : latchList) {
            latch = new CountDownLatch(1);
        }
    }

    public static class mythread1 extends Thread{


        @Override
        public void run() {

            G=G*cur;
            sum=sum+G;
            System.out.println("线程1启动"+sum);
            cur++;
            p2.countDown();
        }
    }
    public static class mythread2 extends Thread{


        @Override
        public void run() {
            try {
                p2.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            G=G*cur;
            sum=sum+G;
            System.out.println("线程2启动"+sum);
            cur++;
            p3.countDown();
        }
    }
    public static class mythread3 extends Thread{


        public void run() {
            try {
                p3.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            G=G*cur;
            sum=sum+G;
            System.out.println("线程3启动"+sum);
            cur++;
            p4.countDown();
        }
    }
    public static class mythread4 extends Thread{


        public void run() {
            try {
                p4.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            G=G*cur;
            sum=sum+G;
            System.out.println("线程4启动"+sum);
            cur++;
            p5.countDown();
        }
    }
    public static class mythread5 extends Thread{


        public void run() {
            try {
                p5.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            G=G*cur;
            sum=sum+G;
            System.out.println("线程5启动"+sum);
            cur++;
            p6.countDown();

        }
    }

    public static class MyThread implements Runnable {

        private MyThread() {

        }


        @Override
        public void run() {
            G *= cur;
            sum += G;
            System.out.println(sum);
            cur++;

        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread t1 = new mythread1();
        Thread t2 = new mythread2();
        Thread t3 = new mythread3();
        Thread t4 = new mythread4();
        Thread t5 = new mythread5();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            p6.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("1！+2！+3！+4！+5！="+sum);


    }

}
