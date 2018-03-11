package reflect.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author j_cong
 * @date 2017年9月26日
 * @describe 使用Proxy和InvocationHandler生成动态代理对象，Spring中AOP用到此方法
 * @version V1.0.0
 */

interface Person1 {
	
	void walk();
	void sayHello(String name);
	
}

class MyInvocationHandler implements InvocationHandler {

    /**
     *
     * @param proxy   代表动态代理对象
     * @param method  代表正在执行的方法
     * @param args    代表调用目标方法时传入的实参
     * @return
     * @throws Throwable
     */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("----正在执行的方法：" + method);
		if (null != args) {
			System.out.println("下面是执行该方法时传入的参数：");
			
			for (Object val: args) {
				System.out.println(val);
			} 
		} else {
			System.out.println("调用该方法时没有参数！");
		}
		return null;
	}
	
}

public class ProxyTest {

	public static void main(String[] args) {
		
		InvocationHandler handler = new MyInvocationHandler();
		
		Person1 p = (Person1) Proxy.newProxyInstance(Person1.class.getClassLoader(), 
				new Class[]{Person1.class},  handler);
		
		p.walk();
		p.sayHello("孙悟空");
		
	}
}
