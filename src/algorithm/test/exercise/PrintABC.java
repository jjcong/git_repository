package algorithm.test.exercise;

import thread.test.MyThread1;

/**
 * 循环打印A，B，C
 * 
 * @author  j_cong
 * @date    2018/07/20
 * @version V1.0
 */
public class PrintABC {
    public static void main(String[] args) throws InterruptedException {
        //获取开始时间
        long startTime = System.currentTimeMillis();
//        printABC1(100);
        printABC2();

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println();
        //输出程序运行时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }


    /**
     * 性能很差，不可取
     * @param count
     * @throws InterruptedException
     */
    public static void printABC1(int count) throws InterruptedException {

        for (int i = 0; i < count; i++) {
            Thread a = new Thread(new MyThread1("A"));
            a.start();
            a.join();

            Thread b = new Thread(new MyThread1("B"));
            b.start();
            b.join();

            Thread c = new Thread(new MyThread1("C"));
            c.start();
            c.join();

        }
    }
    static class MyThread1 implements Runnable {
        private String name;
        public MyThread1(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.print(name);
        }
    }


    public static void printABC2() {
        new Thread(new MyThread2("A")).start();
        new Thread(new MyThread2("B")).start();
        new Thread(new MyThread2("C")).start();

    }

    static class MyThread2 implements Runnable {

        private String name;
        private static String flag = "A";
        private int count = 100;

        MyThread2(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (count > 0) {
                synchronized (flag) {
                    if (flag.equals(name)) {
                        System.out.print(name);
                        count--;
                        if ("A".equals(name)) {
                            flag = "B";
                        }
                        if ("B".equals(name)) {
                            flag = "C";
                        }
                        if ("C".equals(name)) {
                            flag = "A";
                        }
                    }
                }
            }
        }
    }
}
