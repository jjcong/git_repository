package design.pattern.memento;

/**
 * @author j_cong
 * @date 2017年8月30日
 * @describe 备忘录模式：原始类，包含要保存的属性value以及创建一个备忘录类，用来保存value值
 * @version V1.0.0
 */
public class Original {
	
	private String value;
	
	public Original(String value) {
		this.value = value;
	}
	
	public Memento createMemento() {
		return new Memento(value);
	}
	
	public void restoreMemento(Memento memento) {
		this.value = memento.getValue();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
