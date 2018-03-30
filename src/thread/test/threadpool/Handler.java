package thread.test.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @ Author:  j_cong
 * @ Date:    2017年11月23日
 * @ Version: V1.0.0
 * @ Desc:    缓冲线程池实例-execute运行
 */
public class Handler implements Runnable {

	private String name;
	
	private Handler(String name) {
		this.name = "thread" + name;
	}
	@Override
	public void run() {

		System.out.println(name + " Start.Time = " + new Date() );
		processCommand();
		System.out.println(name + " End.Time = " + new Date() );
	}
	
	private void processCommand() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public static void main(String[] args) {
		System.out.println("ScannerReverseMatrix: Staring at: " + new Date());
//		ExecutorService exec = Executors.newCachedThreadPool();
//		ExecutorService exec = Executors.newFixedThreadPool(5);
//		ExecutorService exec = Executors.newSingleThreadExecutor();
		ExecutorService exec = Executors.newScheduledThreadPool(10);

		for (int i = 0; i < 10; i++) {
			exec.execute(new Handler(String.valueOf(i)));
		}
		exec.shutdown();
		System.out.println("ScannerReverseMatrix: Finished all threads at " + new Date());
	}
}
