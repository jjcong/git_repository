package design.pattern.factory.base;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 抽象工厂测试：拓展功能不需要改动现有的代码，直接实现Sender和Provider接口就好
 * @version V1.0.0
 */
public class BaseFactoryTest {

	public static void main(String[] args) {
		
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.send();		
		
		Provider provider1 = new SendInstanceNewsFactory();
		Sender sender1 = provider1.produce();
		sender1.send();
	}
}
