package thread.test;

/**
 * @author j_cong
 * @date 2017年10月20日
 * @describe synchronized（this）测试
 *      * 一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，
 *        一个时间内只能有一个线程得到执行。 
 *      * 另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块 
 * @version V1.0.0
 */
public class SynchronizedTest1 implements Runnable {

	@Override
	public void run() {
		synchronized(this) {
			for (int i = 0; i < 5; i ++) {
				System.out.println(Thread.currentThread().getName()
						+ " synchronized loop is : " + i);
			}
		}
	}
	
	public static void main(String[] args) {
		
		SynchronizedTest1 th = new SynchronizedTest1();
		
		Thread ta = new Thread(th,"A");
		Thread tb = new Thread(th,"B");
		
		ta.start();
		tb.start();
	}
}
