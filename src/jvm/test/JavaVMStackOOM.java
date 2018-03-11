package jvm.test;

/**
 * @author j_cong
 * @date 2017年10月16日
 * @describe 创建线程导致内存溢出异常
 *       VM Args：-Xss2M
 *       注意：运行此程序可能会使系统进入“假死”状态，谨慎运行！！！
 * @version V1.0.0
 */
public class JavaVMStackOOM {
	
	private void dontStop() {
		while(true) {
		}
	}
	
	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread (new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		
		JavaVMStackOOM oom  = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
	
	

}
