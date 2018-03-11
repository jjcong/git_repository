package reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 
 * @author j_cong
 * @date 2017年8月27日
 * @describe 用反射机制实现获取Customer类中的所有方法
 * @version V1.0.0
 */
public class ReflectTest {

	//该方法实现对Customer对象的拷贝操作
	public Object copy(Object obj) throws  Exception {
		Class<?> classType = obj.getClass();
		
		Constructor cons = classType.getConstructor(new Class[]{});
		Object objCopy = cons.newInstance(new Object[] {});
		 
		//以上两行代码等价于下面一行代码,仅适用于不带参数的构造方法的创建
//		Object obj2 = classType.newInstance();
		 
		//获得对象的所有成员变量
		Field[] fields = classType.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			String firstLetter = name.substring(0, 1).toUpperCase();
			String getMethodName = "get" + firstLetter + name.substring(1);
			String setMethodName = "set" + firstLetter + name.substring(1);
			
			Method getMethod = classType.getMethod(getMethodName, new Class[]{});
			Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});
			
			Object value = getMethod.invoke(obj, new Object[]{});
			setMethod.invoke(objCopy, new Object[]{value});
			 
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		ReflectTest test = new ReflectTest();
		test.copy(new Customer());
	}
	 
}

class Customer {
	
	private Long id;
	private String name;
	private int age;
	
	public Customer() {};
	
	public Customer (String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
