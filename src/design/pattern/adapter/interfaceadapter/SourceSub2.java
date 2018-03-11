package design.pattern.adapter.interfaceadapter;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 接口的适配器模式：方法二
 * @version V1.0.0
 */
public class SourceSub2 extends BaseWrapper {
	
	@Override
    public void method2() {
		System.out.println("The sourceable interface's first Sub2!");
	}

}