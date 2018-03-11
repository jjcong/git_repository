package design.pattern.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 观察者模式：定义需要监控的对象。可以对其进行增删，MySubject变化时，通知列表内存在的对象
 * @version V1.0.0
 */
public abstract class BaseSubject implements Subject {
	
	private Vector<Observable> vector = new Vector<>();
	
	@Override
	public void add(Observable observer) {
		vector.add(observer);
	}
	
	@Override
	public void del(Observable observer) {
		vector.remove(observer);
	}
	
	@Override
	public void notifyObservers() {
		
		Enumeration<Observable> enumo = vector.elements();
		
		while (enumo.hasMoreElements()) {
			enumo.nextElement().update();
		}
	}
	
	
	

}
