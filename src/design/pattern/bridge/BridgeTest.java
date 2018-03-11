package design.pattern.bridge;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 桥接模式：测试类
 * @version V1.0.0
 */
public class BridgeTest {
	
	public static void main(String[] args) {
		
		BaseBridge bridge = new MyBridge();
		
		//调用第一个对象
		Sourceable source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.method();
		
		// 调用第二个对象
		Sourceable source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();

	}
	

}
