package design.pattern.decorator;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 装饰模式：Decorator实现接口
 * @version V1.0.0
 */
public class Decorator implements Sourceable {

	private Sourceable source;
	
	public Decorator(Sourceable source) {
		super();
		this.source = source;
	}
	@Override
	public void method() {
		System.out.println("Before decorator!");
		source.method();
		System.out.println("After decorator!");
	}

}
