package dynamic.proxy.test.jdk;
/**
 * 动态代理测试类
 *
 * @author  j_cong
 * @date    2018/03/13
 * @version V1.0
 */
public class ProxyTest {

    public static void main(String[] args) {

        HelloServiceProxy proxy = new HelloServiceProxy();

        HelloService service = new HelloServiceImpl();

        //绑定代理对象
        service = (HelloService) proxy.bind(service, new Class[] {HelloService.class});

        //service经过绑定，就会进入invoke方法了
        service.sayHello("张三");
        service.run();

    }
}
