package reflect.test;

/**
 * @author j_cong
 * @date 2017年9月26日
 * @describe 利用反射机制测试访类的成员变量值，原始类为Person
 * @version V1.0.0
 */
public class Person {

	private String name;
	
	private int age;

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
