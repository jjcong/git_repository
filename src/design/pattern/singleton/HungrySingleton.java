package design.pattern.singleton;
/**
 * 单例模式--恶汉模式，一开始就加载对象实例,线程安全
 *
 * @author  j_cong
 * @date    2018/03/27
 * @version V1.0
 */
public class HungrySingleton {

    private HungrySingleton () {}

    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }
}
