package dynamic.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

/**
 * @author j_cong
 * @date 2017年8月27日
 * @describe 动态代理实现List的增加
 * @version V1.0.0
 */
public class VectorProxy implements InvocationHandler {

	private Object proxyObj;
	
	public VectorProxy(Object obj) {
		this.proxyObj = obj;
	}
	
	public static Object factory(Object obj) {
		Class<?> classType = obj.getClass();
		
		return Proxy.newProxyInstance(classType.getClassLoader(), classType.getInterfaces(), new VectorProxy(obj));
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("Before calling:" + method);
		
		if (null != args) {
			for (Object obj : args) {
				System.out.println(obj);
			}
		}
		
		Object object = method.invoke(proxyObj, args);
		
		System.out.println("After calling:" + method);
		
		return object;
	}
	
	
	public static void main(String[] args) {
		
		List<String> list = (List) factory(new Vector());
		
		list.add("Hello");
		list.add("World");
		
		System.out.println(list);
	}

}
