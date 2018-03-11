package design.pattern.adapter.methodadapter;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 类的适配器模式：包装类，持有Source的一个实例
 * @version V1.0.0
 */
public class Wrapper implements Targetable {

	private Source source;
	
	public Wrapper(Source source) {
		super();
		this.source = source;
	}
	
	@Override
	public void method1() {
		source.method1();
	}

	@Override
	public void method2() {
		System.out.println("This is the targetable method!");
	}

}
