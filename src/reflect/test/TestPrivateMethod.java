package reflect.test;

import java.lang.reflect.Method;
/**
 * @author j_cong
 * @date 2017年8月27日
 * @describe 用反射机制访问类中的私有方法测试
 * @version V1.0.0
 */
public class TestPrivateMethod {

	public static void main(String[] args) throws Exception, SecurityException {
		PrivateMethodTest p = new PrivateMethodTest();
		Class<?> classType = p.getClass();
		Method method = classType.getDeclaredMethod("sayHello", String.class);
		method.setAccessible(true); //压制java的访问控制检查
		String str = (String) method.invoke(p, "张三");
		
		System.out.println(str);
		
	}
}
