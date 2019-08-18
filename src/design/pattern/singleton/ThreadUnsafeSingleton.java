package design.pattern.singleton;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 线程不安全的单例模式
 * @version V1.0.0
 */
public class ThreadUnsafeSingleton {

	//持有私有静态实例，防止被引用，此处赋值为null，目的是实现延时加载
	private static ThreadUnsafeSingleton instance = null;
	
	//私有构造方法，防止被实例化
	private ThreadUnsafeSingleton() {}
	
	//静态工程方法，创建实例
	public static ThreadUnsafeSingleton getInstance() {
		if (null == instance) {
			instance = new ThreadUnsafeSingleton();
		}
		return instance;
	}
	
	//如果对该对象被用于序列化，可以保证对象在序列化前后保持一致
	public Object readResolve() {
		return instance;
	}
	
}
