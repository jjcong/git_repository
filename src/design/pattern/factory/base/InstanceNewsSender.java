package design.pattern.factory.base;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 抽象工厂模式：新添加的发送及时消息类
 * @version V1.0.0
 */
public class InstanceNewsSender implements Sender {

	@Override
	public void send() {
		
		System.out.println("this is InstanceNews!");
	}

}
