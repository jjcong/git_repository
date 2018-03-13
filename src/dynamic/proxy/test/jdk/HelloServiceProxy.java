package dynamic.proxy.test.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理测试类
 *
 * @author  j_cong
 * @date    2018/03/13
 * @version V1.0
 */
public class HelloServiceProxy implements InvocationHandler {

    private Object target;

    /**
     * 绑定委托对象并返回一个代理占位
     *
     * @param target  真实对象
     * @param interfaces  接口对象
     * @return  代理对象（占位）
     */
    public Object bind(Object target, Class[] interfaces) {

        this.target = target;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                this);
    }


    /**
     *通过代理对象调用方法前首先进入这个方法
     *
     * @param proxy    代理对象
     * @param method   方法，被调用的方法
     * @param args     方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是JDK动态代理");
        Object result = null;

        System.out.println("调用方法之前");
        result = method.invoke(target, args);
        System.out.println("调用方法之后");

        return result;

    }
}
