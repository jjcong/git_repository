package design.pattern.builder;

import java.util.List;
import java.util.ArrayList;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 建造者模式测试：建造者类，包含多种服务
 * @version V1.0.0
 */
public class Builder {
	

	public void produceMailSender(int count) {

        List<Sender> listSender =  new ArrayList<>();

		for (int i = 0; i < count; i++) {
            listSender.add(new MailSender());
		}

		for (Sender sender : listSender) {
            sender.send();
        }
	}
	
	public void produceMessageSender(int count) {

        List<Sender> listSender =  new ArrayList<>();

		for (int i = 0; i < count; i++) {
            listSender.add(new MessageSender());
		}

        for (Sender sender : listSender) {
            sender.send();
        }
	}
	

}
