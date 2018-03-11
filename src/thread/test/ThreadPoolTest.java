package thread.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
/**
 * 线程池测试
 *   1) 调用Executors类的静态工厂方法创建一个ExecutorService对象（线程池）
 *   2) 创建Runnable实现类或Callable实现类的实例
 *   3) 调用ExecutorService对象的submit()方法提交任务
 *   4) 调用ExecutorService对象的shutdown()方法关闭线程池
 *
 * @author  j_cong
 * @date    2017/10/04
 * @version V1.0
 */
class NewThread implements Runnable {

	private int i;
	@Override
	public void run() {

		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + 
					"的i值为：" + i);
		}
	}
}

public class ThreadPoolTest {

	public static void main(String[] args) {
		
		//创建一个具有固定线程数（6）的线程池
		ExecutorService pool = Executors.newFixedThreadPool(6);
		
		//创建实现了Runuable接口的线程
		NewThread target = new NewThread();
		new Thread(target);
		
		//向线程池中提提交两个线程
		pool.submit(target);
		pool.submit(target);
		
		pool.shutdown();
		
	}
}
