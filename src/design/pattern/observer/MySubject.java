package design.pattern.observer;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 观察者模式：主对象
 * @version V1.0.0
 */
public class MySubject extends BaseSubject {

	@Override
	public void operation() {

		System.out.println("Update self！");
		notifyObservers();
	}
}
