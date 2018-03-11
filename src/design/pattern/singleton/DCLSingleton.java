package design.pattern.singleton;

/**
 * @author j_cong
 * @date 2017年9月3日
 * @describe 线程安全的单例模式：懒汉式的双重校验锁模式变种，实现了延迟加载和线程安全
 *           这种方式并不是绝对是线程安全的，问题在于对线程可能看到一个被部分初始化的对象
 *           应加上volatile
 * @version V1.0.0
 */
public class DCLSingleton {

    //不加volatile无法保证线程安全，详见Java并发编程实战P286
	private static volatile DCLSingleton instance;
	
	private DCLSingleton() {}
	
	public static DCLSingleton getInstance() {
		if (instance == null) {
			synchronized (DCLSingleton.class) {
				if (instance == null) {
					instance = new DCLSingleton();
				}
			}
		}
		return instance;
	}
	
	
}
