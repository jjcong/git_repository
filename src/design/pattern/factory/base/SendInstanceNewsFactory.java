package design.pattern.factory.base;

/**
 * @author j_cong
 * @date 2017年8月31日
 * @describe 抽象工厂模式：发送及时消息工厂类
 * @version V1.0.0
 */
public class SendInstanceNewsFactory implements Provider {

	@Override
	public Sender produce() {
		
		return new InstanceNewsSender();
	}

}
