package algorithm.test.exercise.queue;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.LinkedList;

/**
 * 使用wait、notify实现生产者消费者模型
 *
 * @author  j_cong
 * @date    2018/08/25
 * @version V1.0
 */
public class ProducerConsumerPattern {

    public static  final  int MAX_CAPACITY = 5;
    public static LinkedList<Object> list = new LinkedList<>();

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.size() == MAX_CAPACITY) {
                        try {
                            System.out.println("当前产品个数为" + list.size() + ",等待消费");
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前产品个数为" + list.size());
                    list.add(new Object());
                    System.out.println("生产了一个产品，当前产品个数为" + list.size());
                    list.notifyAll();

                }

                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.isEmpty()) {
                        try {
                            System.out.println("当前产品个数为" + list.size());
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前产品个数为" + list.size());
                    list.remove();
                    System.out.println("消费了一个产品，当前产品个数为" + list.size());
                    list.notifyAll();
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3 ; i++) {
            new Thread(new Producer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer()).start();
        }
    }

}
