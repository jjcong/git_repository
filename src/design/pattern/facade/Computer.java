package design.pattern.facade;

/**
 * 外观模式：Computer,包含CPU，Memory，Disk
 *
 * @author  j_cong
 * @date    2018/08/28
 * @version V1.0
 */
public class Computer {

	private CPU cpu;
	private Memory memory;
	private Disk disk;
	
	public Computer() {
		cpu = new CPU();
		memory  = new Memory();
		disk = new Disk();
	}
	
	public void startup() {
		System.out.println("start the computer!");
		cpu.startup();
		memory.startup();
		disk.startup();
		System.out.println("start computer finished!");
	}
	
	public void shutdown() {
		System.out.println("begin to close the computer!");
		cpu.startup();
		memory.startup();
		disk.startup();
		System.out.println("computer closed!");
	}
	
	
}
