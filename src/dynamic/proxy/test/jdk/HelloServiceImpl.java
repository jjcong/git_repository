package dynamic.proxy.test.jdk;

/**
 * 动态代理接口实现类
 *
 * @author  j_cong
 * @date    2018/03/13
 * @version V1.0
 */
public class HelloServiceImpl implements HelloService {

    public String name;

    public HelloServiceImpl() {
        this.name = name;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

    @Override
    public void run() {
        System.out.println("I can run!");
    }
}
