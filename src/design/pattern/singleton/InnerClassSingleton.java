package design.pattern.singleton;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 线程安全的单例模式
 *  单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，
 *  这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，JVM能够
 *  帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕,
 *  同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题.
 * @version V1.0.0
 */
public class InnerClassSingleton {

	//私有构造方法，防止被实例化
	private InnerClassSingleton() {}
	
	//此处使用一个嵌套内部类来维护单例
	private static class SingletonFactory {
		
		private static InnerClassSingleton instance = new InnerClassSingleton();
	}
	
	//静态工厂方法，创建实例
	public static InnerClassSingleton getInstance() {
		
		return SingletonFactory.instance;
	}
	
	//如果对该对象被用于序列化，可以保证对象在序列化前后保持一致
	public Object readResolve() {
		return getInstance();
	}
	
}
