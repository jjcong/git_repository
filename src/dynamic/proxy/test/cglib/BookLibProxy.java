package dynamic.proxy.test.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class BookLibProxy implements MethodInterceptor {

    private Object target;

    public BookLibProxy(Object target) {
        this.target = target;
    }

    public Object getInstance() {

        //增强器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("事务开始");

        method.invoke(o, objects);

        System.out.println("事务结束");

        return null;
    }
}
