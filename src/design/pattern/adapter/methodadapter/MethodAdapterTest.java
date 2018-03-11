package design.pattern.adapter.methodadapter;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 方法的适配器模式：测试类
 * @version V1.0.0
 */
public class MethodAdapterTest {
	
	public static void main(String[] args) {
		
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
		
	}

}
