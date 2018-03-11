package design.pattern.adapter.classadapter;

/**
 * @author j_cong
 * @date 2017年8月28日
 * @describe 类的适配器模式：目标的拓展方法
 * @version V1.0.0
 */
public interface Targetable {
	//与原类中的方法相同
	 void method1();
	
	//新类的方法
	 void method2();

}
