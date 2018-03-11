package proxy.test;

/**
 * @author j_cong
 * @date 2017年8月27日
 * @describe 静态代理测试：客户端访问代理角色完成操作
 * @version V1.0.0
 */
public class ClientTest {

	public static void main(String[] args) {
		
		BaseSubject baseSubject = new ProxySubject();
		baseSubject.request();
	}
}
