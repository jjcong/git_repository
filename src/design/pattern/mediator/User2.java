package design.pattern.mediator;

/**
 * @author j_cong
 * @date 2017年8月31日
 * @describe 中介者模式：独立的User2，只需要保持与Mediator的关系就可以
 * @version V1.0.0
 */
public class User2 extends BaseUser {
	
	public User2(Mediator mediator) {
		super(mediator);
	}
	
	@Override
	public void work() {
		System.out.println("User2 exe!");
	}

}
