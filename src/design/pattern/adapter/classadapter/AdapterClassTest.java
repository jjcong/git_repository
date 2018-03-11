package design.pattern.adapter.classadapter;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 类的适配器模式：适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。
 * @version V1.0.0
 */
public class AdapterClassTest {
	
	public static void main(String[] args) {
		
		Targetable target = new Adapter();

		target.method1();
		target.method2();
	}
}
