package design.pattern.responsibility.chain;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 责任链模式：每个对象持有对下一个对象的引用，这样就会形成一条链，
 *                      请求在这条链上传递，直到某一对象决定处理该请求。
 * @version V1.0.0
 */
public class ResponsibilityChainTest {
	
	public static void main(String[] args) {
		MyHandler h1 = new MyHandler("h1");
		MyHandler h2 = new MyHandler("h2");
		MyHandler h3 = new MyHandler("h3");
		
		h1.setHandler(h2);
		h2.setHandler(h3);
		
		h1.operator();
	}

}
