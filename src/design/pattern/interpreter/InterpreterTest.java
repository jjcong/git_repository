package design.pattern.interpreter;

/**
 * @author j_cong
 * @date 2017年8月31日
 * @describe 解释器模式：一般用于OOP开发中的编译器开发，适用面比较窄
 * @version V1.0.0
 */
public class InterpreterTest {

	public static void main(String[] args) {

		// 计算9+2-8的值
		int result = new Minus().interpret((new Context(new Plus()
				.interpret(new Context(9, 2)), 8)));
		System.out.println(result);

	}
}