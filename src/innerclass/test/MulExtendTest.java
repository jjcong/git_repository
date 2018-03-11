package innerclass.test;

/**
 * @ Author:  j_cong
 * @ Date:    2017-10-22
 * @ Version: V1.0
 * @ Desc:    使用内部类实现多继承：测试类
 */
public class MulExtendTest {

	public static void main(String[] args) {
		
		Son son = new Son();
		
		System.out.println("Son的Strong:" + son.getStrong());
		System.out.println("Son的Kind:" + son.getKind());
	}
}
