package thread.test;

public class MyThread1 extends Thread {
	private String name;

	private MyThread1(String name) {
		this.name = name;
	}

	@Override
    public void run() {
		System.out.println("hello " + name);
	}

	public static void main(String[] args) {
		Thread thread = new MyThread1("world");
		thread.start();
	}
}
