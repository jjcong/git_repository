package design.pattern.mediator;

/**
 * @author j_cong
 * @date 2017年8月31日
 * @describe 中介者模式：用来降低类类之间的耦合，类似于Spring容器
 * @version V1.0.0
 */
public class MediatorTest {
	
	public static void main(String[] args) {
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}

}
