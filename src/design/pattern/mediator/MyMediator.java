package design.pattern.mediator;

/**
 * @author j_cong
 * @date 2017年8月31日
 * @describe 中介者模式：接口实现类，持有User1 和 User2 两个实例
 * @version V1.0.0
 */
public class MyMediator implements Mediator {

	private BaseUser user1;
	private BaseUser user2;
	
	public BaseUser getUser1() {
		return user1;
	}

	public BaseUser getUser2() {
		return user2;
	}

	@Override
	public void createMediator() {
		user1 = new User1(this);
		user2 = new User2(this);
	}

	@Override
	public void workAll() {
		user1.work();
		user2.work();
	}

}
