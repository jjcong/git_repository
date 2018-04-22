package thread.test.threadpool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 三个线程循环打印ABC
 *
 * @author  j_cong
 * @date    2018/04/17
 * @version V1.0
 */
public class ABCTest {
    public static void main(String[] args) {

        final String str = "ABC";
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1" + str);
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("2" + str);
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("3" + str);
            }
        });
    }
}
