package dynamic.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author j_cong
 * @date 2017年8月27日
 * @describe 动态代理测试:客户端测试
 * @version V1.0.0
 */
public class ClientTest {

	public static void main(String[] args) {

		RealSubject realSubject = new RealSubject();
		InvocationHandler handler = new DynamicProxySubject(realSubject);
		
		Class<?> classType = handler.getClass();
		//下面的代码一次性生成代理
		//Proxy.newProxyInstance生成一个动态类（$Proxy0）的实例，实现了定义的接口
		Subject subject = (Subject) Proxy.newProxyInstance(classType.getClassLoader(), realSubject.getClass().getInterfaces(), handler);
		subject.request();
		
		System.out.println(subject.getClass());
		
	}
}
