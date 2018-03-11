package proxy.test;

/**
 * @author j_cong
 * @date 2017年8月27日
 * @describe 静态代理测试：真实角色定义
 * @version V1.0.0
 */
public class RealSubject extends BaseSubject {

	@Override
	public void request() {
		 System.out.println("from real subject");
	}

}
