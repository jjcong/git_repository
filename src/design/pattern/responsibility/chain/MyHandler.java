package design.pattern.responsibility.chain;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 责任链模式：核心，实例化后生成一系列相互持有的对象，构成一条链
 * @version V1.0.0
 */
public class MyHandler extends BaseHandler implements Handler {

	private String name;
	
	public MyHandler(String name) {
		this.name = name;
	}
	
	@Override
	public void operator() {
		System.out.println(name + "deal!");
		if (null != getHandler()) {
			getHandler().operator();
		}
	}

}
