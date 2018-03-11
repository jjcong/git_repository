package design.pattern.builder;


/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 建造者模式测试：发送邮件类
 * @version V1.0.0
 */
public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is MailSender!");
	}

}
