package dynamic.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * @author j_cong
 * @date 2017年8月27日
 * @describe 动态代理测试:声明动态代理
 * @version V1.0.0
 */

public class DynamicProxySubject implements InvocationHandler {
	
	private Object sub;
	
	public DynamicProxySubject(Object obj) {
		
		this.sub = obj;
	}
		
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		

		System.out.println("Before calling:" + method);
		
		method.invoke(sub, args);
		
		System.out.println("After calling:" + method);
		
		return null;
	}

}
