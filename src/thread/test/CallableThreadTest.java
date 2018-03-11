package thread.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/**
 * @author j_cong
 * @date 2017年10月4日
 * @describe 使用Callable创建线程
 * @version V1.0.0
 */
public class CallableThreadTest {

	public static void main(String[] args) {
		//创建Callable对象
		CallThread ct = new CallThread();
		
		//使用FutureTask来包装对象
		FutureTask<Integer> task = new FutureTask<>(ct);
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()
					+ " 的循环变量i的值为" + i);
			if (20 == i) {
				new Thread(task, "有返回值的线程").start();
			}
		}
		try {
			//获取线程的返回值
			System.out.println("子线程的返回值：" + task.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class CallThread implements Callable<Integer> {

	private int i = 0;
	
	@Override
	public Integer call() throws Exception {
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()
					+ " 的循环变量i的值为" + i);
		}
		return i;
	}
 }
	

