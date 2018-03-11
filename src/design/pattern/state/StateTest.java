package design.pattern.state;

import java.net.URLEncoder;

/**
 * @author j_cong
 * @date 2017年8月30日
 * @describe 状态模式：当对象的状态改变时，同时改变其行为，类似于QQ状态
 * @version V1.0.0
 */
public class StateTest {
	
	public static void main(String[] args) {

		State state = new State();

		Context context = new Context(state);
		
		//设置第一种状态
		state.setValue("state1");
		context.method();
		
		//设置第二种状态
		state.setValue("state3");
		context.method();
		
	}

}
