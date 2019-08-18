package algorithm.test.exercise.JdkDynamicProxy;

public class ProxyTest {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(service);
        UserService proxyService = (UserService)invocationHandler.getProxy();
        proxyService.sayHello();
    }
}
