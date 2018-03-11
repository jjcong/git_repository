package reflect.test;

import java.lang.reflect.Array;

/**
 * 
 * @author j_cong
 * @date 2017年8月27日
 * @describe 用反射机制创建Array数组
 * @version V1.0.0
 */
public class ArrayListTest {
	
	public static void main(String[] args) throws Exception {
		//方式一
//		Class<?> classType = Class.forName("java.lang.String");
		//方式二
//		Class<?> classType = String.class;
		//方式三
		String s = "a";
		Class<?> classType = s.getClass();
		
		Object array = Array.newInstance(classType, 10);
		Array.set(array, 5, "Hello");
		String str = (String)Array.get(array, 5);
		
		System.out.println(str);
	}

}
