package design.pattern.facade;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 外观模式：定义Memory和两个方法startup(),shutdown()
 * @version V1.0.0
 */
public class Memory {
	
	public void startup() {
		System.out.println("Memory startup!");
	}
	
	public void shutdown() {
		System.out.println("Memory shutdown!");
	}

}
