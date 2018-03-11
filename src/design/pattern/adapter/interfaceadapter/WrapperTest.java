package design.pattern.adapter.interfaceadapter;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 接口的适配器模式：测试方法，定义一个抽象类，实现接口的所有方法，以后的方法只与之联系
 * @version V1.0.0
 */
public class WrapperTest {
	
	public static void main(String[] args) {

		Sourceable source1 = new SourceSub1();
		Sourceable source2 = new SourceSub2();
		
		source1.method1();
		source1.method2();
		source2.method1();
		source2.method2();
		
	}

}
