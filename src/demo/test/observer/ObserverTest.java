package demo.test.observer;

public class ObserverTest {

	public static void main(String[] args) {
		Subject sub = new Subject();
		MyObserver1 observer1 = new MyObserver1();
		MyObserver2 observer2 = new MyObserver2();
		
		sub.addObserver(observer1);
		sub.addObserver(observer2);
		
		sub.counter(10);
		
	}

}
