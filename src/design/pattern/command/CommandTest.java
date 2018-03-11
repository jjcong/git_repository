package design.pattern.command;

/**
 * @author j_cong
 * @date 2017年8月30日
 * @describe 命令模式：两个类互相解耦，任何一方都不依赖对方，类似司令员和士兵
 * @version V1.0.0
 */
public class CommandTest {
	
	public static void main(String[] args) {
		
		Receiver receiver = new Receiver();
		Command cmd = new MyCommand(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
		
	}

}
