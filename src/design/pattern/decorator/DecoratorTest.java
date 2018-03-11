package design.pattern.decorator;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 装饰模式：测试
 * @version V1.0.0
 */
public class DecoratorTest {
	
	public static void main(String[] args) {
		
		Sourceable source = new Source();
		Sourceable obj = new Decorator(source);

		obj.method();
	}

}
