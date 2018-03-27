package design.pattern.singleton;
/**
 * 单例模式--懒汉模式，需要使用的时候再加载对象实例
 *
 * @author  j_cong
 * @date    2018/03/27
 * @version V1.0
 */
public class LazySingleton {

    private LazySingleton() {}

    private static LazySingleton instance = null;

    public static LazySingleton getInstance() {

        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
