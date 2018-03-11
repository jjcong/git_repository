package jvm.test;

/**
 * @author j_cong
 * @date 2017年10月17日
 * @describe <clinit>()方法调用顺序测试
 * @version V1.0.0
 */
public class ClinitTest {

	public static int A = 1;
	
	static {
		A = 2;
	}
	
	static class Sub extends ClinitTest {
		
		public static int B = A;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Sub.B);
	}
}
