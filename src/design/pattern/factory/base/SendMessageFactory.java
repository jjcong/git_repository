package design.pattern.factory.base;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 抽象工厂测试：新添加的发送短信息工厂类
 * @version V1.0.0
 */
public class SendMessageFactory implements Provider {

	@Override
	public Sender produce() {

		return new MessageSender();
	}

}
