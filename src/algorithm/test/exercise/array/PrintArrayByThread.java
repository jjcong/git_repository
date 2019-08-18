package algorithm.test.exercise.array;
/**
 * 多线程打印数组
 *
 * @author  j_cong
 * @date    2018/09/07
 * @version V1.0
 */
public class PrintArrayByThread {

    static volatile int curr = 0;
    static volatile int status = 0;
    static final int THREADS = 4;
    static final int STOP = 100;
    public static void main(String[] args) {
        for (int i = 0; i < THREADS; i++) {
            final int n = i;
            new Thread(() -> {f(n);}, String.valueOf(i)).start();
        }
    }

    public static void f(int number) {
        while (curr <= STOP) {
            if (status == number && curr <= STOP) {
                System.out.println(Thread.currentThread().getName() + "::" + curr);
                curr++;
                status = (status + 1) % THREADS;
            }
        }
    }
}
