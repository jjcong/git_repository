package reflect.test;

/**
 * @author j_cong
 * @date 2017年8月27日
 * @describe 用反射机制访问类中的私有方法测试
 * @version V1.0.0
 */
public class PrivateMethodTest {
	private String sayHello(String name) {
		return "Hello:" + name;
	}

}
