package reflect.test;

/**
 * @author j_cong
 * @date 2017年8月27日
 * @describe 用反射机制访问类中的私有属性测试
 * @version V1.0.0
 */
public class PrivateFieldTest {
	
	private String name = "张三";

	public String getName() {
		return name;
	}

}
