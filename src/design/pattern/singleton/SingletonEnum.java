package design.pattern.singleton;

/**
 * @author j_cong
 * @date 2017年9月3日
 * @describe 线程安全的单例模式:枚举类，效率高，推荐使用
 *           默认继承了java.lang.Enum类，实现java.lang.Serializable和java.lang.Comparable两个接口
 * @version V1.0.0
 */
public enum SingletonEnum {

	//必须在第一行列出所有的实例，默认为public static final,无需显示指定
	INSTANCE;  
	
	//定义构造方法，修饰符必须为private
	private SingletonEnum() {}
	
	public void method() {}
	
	public static SingletonEnum getInstance() {
		return INSTANCE;
	}
	
}
