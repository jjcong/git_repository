package thread.test;

/**
 * 没有同步的情况下共享变量
 *
 * @author  j_cong
 * @date    2017/10/20
 * @version V1.0
 */
public class NoVisibility {

	private static boolean ready;
	private static int number;
	
	private static class ReaderThread extends Thread {
		@Override
		public void run() {
			while (!ready) {
				Thread.yield();
			}
			System.out.println(number);
		}
	}
	public static void main(String[] args) {
		
		new ReaderThread().start();
		number = 42;
		ready = true;
	}
}
