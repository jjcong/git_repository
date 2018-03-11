package design.pattern.observer;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 观察者模式：增删观察者，以及进行其他的操作
 * @version V1.0.0
 */
public interface Subject {
	
	//增加观察者
	void add(Observable observable);
	
	//删除观察者
	void del(Observable observable);
	
	//通知所有的观察者
	void notifyObservers();
	
	//自身的操作
	void operation();

}
