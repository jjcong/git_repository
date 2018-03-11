package innerclass.test;

/**
 * @author j_cong
 * @date 2017年9月27日
 * @describe 匿名内部类测试，自动创建对象，适用于只需要一次使用的类
 * @version V1.0.0
 */

interface Product {
	double getPrice();
	String getName();
}

public class AnonymousTest {

	public void test (Product p) {
		System.out.println("购买了一个" + p.getName()
				+ ",花费了" + p.getPrice());
	}
	
	public static void main(String[] args) {
		
		AnonymousTest ta = new AnonymousTest();

		ta.test(new Product() {
			public double getPrice() {
				return 567.8;
			}

			public String getName() {
				return "AGP显卡";
			}

		});
	}
}
