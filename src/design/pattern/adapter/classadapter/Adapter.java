package design.pattern.adapter.classadapter;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 类的适配器模式：适配器类定义
 * @version V1.0.0
 */
public class Adapter extends Source implements Targetable {

    @Override
	public void method2() {
		System.out.println("This is the targetable method!");
	}

}
