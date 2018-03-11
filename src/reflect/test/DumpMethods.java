package reflect.test;

import java.lang.reflect.Method;
/**
 * 
 * @author j_cong
 * @date 2017年8月27日
 * @describe 用反射机制输出指定类中的所有方法
 * @version V1.0.0
 */
public class DumpMethods {
	public static void main(String[] args) throws Exception {
		Class<?> classType = Class.forName(args[0]);
		Method[] methods = classType.getDeclaredMethods();
		
		for (Method method : methods) {
			System.out.println(method);
		}
	}
}
