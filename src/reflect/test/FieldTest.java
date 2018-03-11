package reflect.test;

import java.lang.reflect.Field;

/**
 * @author j_cong
 * @date 2017年9月26日
 * @describe 利用反射机制测试访类的成员变量值，原始类为Person
 * @version V1.0.0
 */
public class FieldTest {

	public static void main(String[] args) throws Exception, SecurityException {
		
		Person p = new Person();
		
		Class<Person> personClazz = Person.class;
		
		Field nameField = personClazz.getDeclaredField("name");
		
		nameField.setAccessible(true);
		
		//必须取消私有成员变量的访问权限，才能进行后续操作
		nameField.set(p, "Alice");
		
		Field ageField = personClazz.getDeclaredField("age");
		
		ageField.setAccessible(true);
		
		ageField.set(p, 22);
		
		System.out.println(p);
		
	}
}
