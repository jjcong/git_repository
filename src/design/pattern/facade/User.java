package design.pattern.facade;

/**
 * 外观模式：用户操作Computer，（解耦）解决类与类之间的依赖关系
 *
 * @author  j_cong
 * @date    2018/08/28
 * @version V1.0
 */
public class User {
	
	public static void main(String[] args) {
		
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
		
	}

}
