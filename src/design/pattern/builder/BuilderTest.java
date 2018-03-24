package design.pattern.builder;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 建造者模式测试：测试类，
 * @version V1.0.0
 */

public class BuilderTest {

	public static void main(String[] args) {

		Builder builder = new Builder();
		
		//创建10个消息服务的实例
		builder.produceMessageSender(10);
		//创建10个邮件服务的实例
		builder.produceMailSender(10);
	}
	
}
