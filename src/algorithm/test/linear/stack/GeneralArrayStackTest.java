package algorithm.test.linear.stack;

/**
 * @author j_cong
 * @date 2017年9月12日
 * @describe 数组实现的栈，能存储任意类型的数据.测试类
 * @version V1.0.0
 */
public class GeneralArrayStackTest {

	public static void main(String[] args) {
		
		String tmp;
		GeneralArrayStack<String> astack = new GeneralArrayStack<>(String.class);
		
		astack.push("10");
		astack.push("20");
		astack.push("30");
		
		//将栈顶元素赋给tmp，并删除栈顶元素
		tmp = astack.pop();
		System.out.println("tmp = " + tmp);
		
		//只将栈顶赋给tmp，不删除该元素
		tmp = astack.peek();
		System.out.println("tmp = " + tmp);
		
		astack.push("40");
		astack.PrintArrayStack();
	}
}
