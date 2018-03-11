package thread.test;

/**
 * @author j_cong
 * @date 2017年10月3日
 * @describe join线程测试
 *           当在某个程序执行流中调用其他线程的join()时，调用线程将被堵塞，
 *           直到被join()方法加入的join线程执行结束为止
 * @version V1.0.0
 */
public class JoinThread extends Thread {
	// 提供一个有参数的构造器，用于设置该线程的名字
	private JoinThread(String name) {
		super(name);
	}

	// 重写run()方法，定义线程执行体
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + "  " + i);
		}
	}

	public static void main(String[] args) throws Exception {
		// 启动子线程
		new JoinThread("新线程").start();
		for (int i = 0; i < 100; i++) {
			if (i == 20) {
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				// main线程调用了jt线程的join()方法，main线程
				// 必须等jt执行结束才会向下执行
				jt.join();
			}
			System.out.println(Thread.currentThread().getName() + "  " + i);
		}
	}
}
