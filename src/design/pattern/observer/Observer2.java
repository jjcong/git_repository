package design.pattern.observer;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 观察者模式：依赖于MySubject的对象，随MySubject变化而变化
 * @version V1.0.0
 */
public class Observer2 implements Observable {

	@Override
	public void update() {
		System.out.println("Observer2 has received!");
	}

}
