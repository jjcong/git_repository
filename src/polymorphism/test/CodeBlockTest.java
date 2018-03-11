package polymorphism.test;

/**
 * @author j_cong
 * @date 2017年9月28日
 * @describe 静态代码块、构造代码块、构造函数执行顺序测试
 *             静态代码块 > 构造代码块 > 构造函数
 * @version V1.0.0
 */
public class CodeBlockTest {

	/*
	 * 静态代码块
	 */
	static {
		System.out.println("执行静态代码块......");
	}
	
	/*
	 * 构造代码块
	 */
	{
		System.out.println("执行构造代码块......");
	}
	
	/*
	 * 无参构造函数
	 */
	public CodeBlockTest() {
		System.out.println("执行无参构造函数......");
	}
	
	/*
	 * 有参构造函数
	 */
	public CodeBlockTest(String id) {
		System.out.println("执行有参构造函数......");
	}
	
	public static void main(String[] args) {
		
		System.out.println("-------------------");
		new CodeBlockTest();
		System.out.println("-------------------");
		new CodeBlockTest("1");
	}
}
