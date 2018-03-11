package design.pattern.observer;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 观察者模式：当一个对象变化时，其他依赖该对象的对象都会收到通知，并且随之变化
 * @version V1.0.0
 */
public class ObserverTest {

	public static void main(String[] args) {
		
		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());
		
		sub.operation();
	}
}
