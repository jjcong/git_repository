package design.pattern.factory.base;


/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 抽象工厂测试：发送邮件工厂类
 * @version V1.0.0
 */
public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {

		return new MailSender();
	}

}
