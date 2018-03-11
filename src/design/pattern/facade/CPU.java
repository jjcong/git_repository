package design.pattern.facade;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 外观模式：定义CPU和两个方法startup(),shutdown()
 * @version V1.0.0
 */
public class CPU {
	
	public void startup() {
		System.out.println("CPU startup!");
	}
	
	public void shutdown() {
		System.out.println("CPU shutdown!");
	}

}
