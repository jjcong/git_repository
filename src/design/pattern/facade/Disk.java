package design.pattern.facade;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 外观模式：定义Disk和两个方法startup(),shutdown()
 * @version V1.0.0
 */
public class Disk {
	
	public void startup() {
		System.out.println("Disk startup!");
	}
	
	public void shutdown() {
		System.out.println("Disk shutdown!");
	}

}
