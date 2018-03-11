package innerclass.test;

/**
 * @author j_cong
 * @date 2017年9月27日
 * @describe Thread类的匿名内部类实现
 * @version V1.0.0
 */
public class ThreadDemo {

	public static void main(String[] args) { 
		
		Thread t = new Thread() {
			public void run() {
				for (int i = 0; i <= 5; i++) {
					System.out.print(i + " ");
				}
			}
		};
		t.start();
	}
}
