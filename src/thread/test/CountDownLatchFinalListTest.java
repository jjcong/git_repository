package thread.test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchFinalListTest {

    final static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        //  FinalList ll = new FinalList();
        final CountDownLatch latch = new CountDownLatch(2);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                list.add(2);
                list.add(3);

                latch.countDown();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                list.add(5);
                list.add(6);
                latch.countDown();
            }


        });



        thread.start();
        thread2.start();
        System.out.println("---------");
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        latch.await();
        System.out.println("*********");
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
