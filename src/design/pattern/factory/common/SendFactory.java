package design.pattern.factory.common;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 静态工厂测试：工厂类，返回两个实例
 * @version V1.0.0
 */
public class SendFactory {
	
	public static Sender produceMail() {
		return new MailSender();
	}
	
	public static Sender produceMessage() {
		return new MessageSender();
	}
	
	
}
