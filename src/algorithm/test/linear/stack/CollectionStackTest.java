package algorithm.test.linear.stack;

import java.util.Stack;

/**
 * @author j_cong
 * @date 2017年9月12日
 * @describe Java的Collection集合自带的栈的示例
 * @version V1.0.0
 */
public class CollectionStackTest {

	public static void main(String[] args) {
		int tmp = 0;
		Stack<Integer> astack = new Stack<>();
		
		astack.push(10);
		astack.push(20);
		astack.push(30);
		
		//将栈顶元素赋给tmp，并删除栈顶元素
		tmp = astack.pop();
		System.out.println("tmp = " + tmp);
		
		//只将栈顶元素赋给tmp，不删除栈顶元素
		tmp = astack.peek();
		System.out.println("tmp = " + tmp);
		
		astack.push(40);
		while(!astack.empty()) {
			tmp = (int) astack.pop();
			
			System.out.println("tmp = " + tmp);
		}
	}
}
