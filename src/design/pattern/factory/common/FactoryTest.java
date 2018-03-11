package design.pattern.factory.common;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 静态工厂测试：工厂测试类
 * @version V1.0.0
 */
public class FactoryTest {
	
	public static void main(String[] args) {
		Sender sender = SendFactory.produceMail();
		sender.send();
	}
}
