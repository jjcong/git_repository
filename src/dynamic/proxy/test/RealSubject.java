package dynamic.proxy.test;
/**
 * @author j_cong
 * @date 2017年8月27日
 * @describe 动态代理测试:真实的对象
 * @version V1.0.0
 */

public class RealSubject implements Subject {

	@Override
	public void request() {
		System.out.println("from real subject");
	}

}
