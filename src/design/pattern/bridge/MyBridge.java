package design.pattern.bridge;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 桥接模式：MyBridge继承BaseBridge
 * @version V1.0.0
 */
public class MyBridge extends BaseBridge {
	
	public void method() {
		getSource().method();
	}
}
