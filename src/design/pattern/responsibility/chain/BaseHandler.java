package design.pattern.responsibility.chain;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 责任链模式：包含Handler实例的抽象类
 * @version V1.0.0
 */
public abstract class BaseHandler {
	
	private Handler handler;

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	

}
