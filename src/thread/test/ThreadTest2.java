package thread.test;

public class ThreadTest2 {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread2());
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		
		t1.start();
		t2.start();
		
	} 

}

class MyThread implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			
			System.out.println("Hello:" + i);
		}
	}
	
}



class MyThread2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			
			System.out.println("World:" +i);
		}
	}
	
}
