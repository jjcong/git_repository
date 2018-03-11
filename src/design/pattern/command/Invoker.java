package design.pattern.command;

/**
 * @author j_cong
 * @date 2017年8月30日
 * @describe 命令模式：命令发出者，包含发出的命令（动作）
 * @version V1.0.0
 */
public class Invoker {
	
	private Command command;
	
	public Invoker(Command command) {
		this.command = command;
	}
	
	public void action() {
		command.exe();
	}

}
