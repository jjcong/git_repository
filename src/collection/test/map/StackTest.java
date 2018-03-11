package collection.test.map;

import java.util.Stack;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 
 * @author j_cong
 * @date 2017年8月27日
 * @describe 堆栈测试，先进后出（FILO）
 * @version V1.0.0
 */
public class StackTest {
	public static void main(String[] args) {
		
		Stack stack = new Stack();
		stack.push(new Integer(123));
		stack.push("Hello World!");
		stack.push(new Double(88.88));
		
		Enumeration item = stack.elements();
		while (item.hasMoreElements()) {
			System.out.print(item.nextElement() + ",");
		}
		System.out.println();
		
		//出栈
		while (stack.size() != 0) {
			System.out.print(stack.pop() + ",");
		}
	}
	
}
