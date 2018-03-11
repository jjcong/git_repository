package design.pattern.command;

/**
 * @author j_cong
 * @date 2017年8月30日
 * @describe 命令模式：命令接口实现，包含接收者的实例，以及执行的动作
 * @version V1.0.0
 */
public class MyCommand implements Command {

	private Receiver receiver;
	
	public MyCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void exe() {
		receiver.action();
	
	}

}
