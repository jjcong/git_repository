package design.pattern.singleton;

/**
 * @author j_cong
 * @date 2017年9月3日
 * @describe 单例模式测试：
 * @version V1.0.0
 */
public class SingletonTest {
	
	public static void main(String[] args) {
		
		//懒汉式的双重校验锁模式
		DCLSingleton singleton1 = DCLSingleton.getInstance();
		DCLSingleton singleton2 = DCLSingleton.getInstance();
		
		System.out.println(singleton1);
		System.out.println(singleton2);
		System.out.println(singleton1 == singleton2);
		
		//枚举形式的线程安全的单例模式
		SingletonEnum sEnum1 = SingletonEnum.getInstance();
		SingletonEnum sEnum2 = SingletonEnum.getInstance();
		
		System.out.println(sEnum1);
		System.out.println(sEnum2);
		System.out.println(sEnum1 == sEnum2);
	}
}
