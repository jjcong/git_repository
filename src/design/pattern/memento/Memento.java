package design.pattern.memento;

/**
 * @author j_cong
 * @date 2017年8月30日
 * @describe 备忘录模式：备忘录类
 * @version V1.0.0
 */
public class Memento {
	
	private String value;
	
	public Memento(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
