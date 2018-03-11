package thread.test;

/**
 *
 * @ Author: j_cong
 * @ Date: 2017-10-21
 * @ Version: V1.0
 * @ Describe: 多线程测试
 *          建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，
 *          要求线程同时运行，交替打印10次ABC。
 */
public class MyThreadPrinterTest {

	public static void main(String[] args) throws Exception {

		Object a = new Object();
		Object b = new Object();
		Object c = new Object();

		MyThreadPrinter pa = new MyThreadPrinter("A", c, a);
		MyThreadPrinter pb = new MyThreadPrinter("B", a, b);
		MyThreadPrinter pc = new MyThreadPrinter("C", b, c);

		new Thread(pa).start();
		Thread.sleep(100); // 确保按顺序A、B、C执行
		new Thread(pb).start();
		Thread.sleep(100);
		new Thread(pc).start();
		Thread.sleep(100);

	}
}

class MyThreadPrinter implements Runnable {

	private String name;
	private Object prev;
	private Object self;

	MyThreadPrinter(String name, Object prev, Object self) {

		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	@Override
	public void run() {

		int count = 10;
		while (count > 0) {
			synchronized (prev) {
				synchronized (self) {
					System.out.println(Thread.currentThread().getName() + "---" + name);
					count--;

					self.notify();
				}
				try {
					prev.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
