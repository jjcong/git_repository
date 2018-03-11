package reflect.test;

import java.lang.reflect.Field;

/**
 * @author j_cong
 * @date 2017年8月27日 
 * @describe 用反射机制访问类中的私有属性测试
 * @version V1.0.0
 */
public class TestPrivateField {
	
	public static void main(String[] args) throws Exception, SecurityException {
		PrivateFieldTest p = new PrivateFieldTest();
		Class<?> classType = p.getClass();
		Field field = classType.getDeclaredField("name");
		field.setAccessible(true); //压制java的访问控制检查
		field.set(p, "李四");
		
		System.out.println(p.getName());
		
	}

}
