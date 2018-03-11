package design.pattern.singleton;


/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 线程安全的单例模式
 *           将创建和getInstance()分开，单独为创建加synchronized关键字
 * @version V1.0.0
 */
public class Singleton {

	private static Singleton instance = null;
	
	private Singleton() {}
	
	private static synchronized void syncInit() {
		if (null == instance) {
			instance = new Singleton();
		}
	}
	
	public static Singleton getInstance() {
		if (null == instance) {
			syncInit();
		}
		return instance;
	}
}
