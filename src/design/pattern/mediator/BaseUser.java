package design.pattern.mediator;

/**
 * @author j_cong
 * @date 2017年8月31日
 * @describe 中介者模式：统一接口
 * @version V1.0.0
 */
public abstract class BaseUser {
	
	private Mediator mediator;
	
	public Mediator getMediator() {
		return mediator;
	}
	
	public BaseUser(Mediator mediator) {
		this.mediator = mediator;
	}

	public abstract void work();
	
}
