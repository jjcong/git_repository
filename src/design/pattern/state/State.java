package design.pattern.state;

/**
 * @author j_cong
 * @date 2017年8月30日
 * @describe 状态模式：核心类
 * @version V1.0.0
 */
public class State {
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void method1() {
		System.out.println("Execute the first opt!");
	}
	
	public void method2() {
		System.out.println("Execute the second opt!");
	}
}
