package design.pattern.decorator;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 装饰模式：Source实现接口
 * @version V1.0.0
 */
public class Source implements Sourceable {

	@Override
	public void method() {
		System.out.println("The origial method!");
	}

}
