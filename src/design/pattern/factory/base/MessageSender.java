package design.pattern.factory.base;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 抽象工厂测试：发送消息类
 * @version V1.0.0
 */
public class MessageSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is MessageSender!");
	}

}
