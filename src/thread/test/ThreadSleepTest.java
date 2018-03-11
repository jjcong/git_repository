package thread.test;

/**
 * @author j_cong
 * @date 2017年10月3日
 * @describe 线程睡眠测试
 * @version V1.0.0
 */
public class ThreadSleepTest {
	
	public static void main(String[] args) {
		
		Runnable r = new ThreadSleep();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}

}

class ThreadSleep implements Runnable {
	
	int i;

	@Override
	public void run() {
//		int i = 0;
		while (true) {
			
			System.out.println("number" + i++);
		
		try {
			
			Thread.sleep((long)(Math.random() * 1000));
			
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (50 == i) {
			break;
		}
	}
	
  }
}
