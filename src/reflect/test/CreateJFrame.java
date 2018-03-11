package reflect.test;

import java.lang.reflect.Constructor;

/**
 * @author j_cong
 * @date 2017年9月26日
 * @describe 利用反射机制创建指定构造器的JFrame类实例
 * @version V1.0.0
 */
public class CreateJFrame {

	public static void main(String[] args) throws Exception {
		
		Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
		
		Constructor ctor = jframeClazz.getConstructor(String.class);
		
		Object obj = ctor.newInstance("测试窗口");
		
		System.out.println(obj);
	}
}
