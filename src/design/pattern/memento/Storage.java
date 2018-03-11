package design.pattern.memento;

/**
 * @author j_cong
 * @date 2017年8月30日
 * @describe 备忘录模式：存储备忘录的类，持有Memento类的实例
 * @version V1.0.0
 */
public class Storage {
	
	private Memento memento;
	
	public Storage(Memento memento) {
		this.memento = memento;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	

}
