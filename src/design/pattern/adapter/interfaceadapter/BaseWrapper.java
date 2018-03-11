package design.pattern.adapter.interfaceadapter;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 接口的适配器模式：抽象类，实现Sourceable接口的两个方法
 * @version V1.0.0
 */
public  abstract class BaseWrapper implements Sourceable {

	@Override
    public void method1() {
        System.out.println("BaseWrapper method1");
    }

	@Override
    public void method2() {
        System.out.println("BaseWrapper method2");
    }

}
