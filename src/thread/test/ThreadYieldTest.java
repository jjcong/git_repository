package thread.test;

public class ThreadYieldTest {
	
	public static void main(String[] args) {
		
		MyThreadYield yt1 = new MyThreadYield("张三");
		MyThreadYield yt2 = new MyThreadYield("李四");
		
		yt1.start();
		yt2.start();
		
	}
	
}

 class MyThreadYield extends Thread {
	 
	 public MyThreadYield(String name) {
			
			super(name); 
		}

		@Override
		public void run () {
			
			for (int i = 1; i <= 50; i++) {
				System.out.println("" + this.getName() + "-----" + i);  
				if (i == 30) {
                    MyThreadYield.yield();
				}
			}
		}
}