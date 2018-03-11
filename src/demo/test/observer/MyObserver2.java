package demo.test.observer;

import java.util.Observable;
import java.util.Observer;

public class MyObserver2 implements Observer {

	@Override
	public void update(Observable o, Object arg) {

		if (((Integer)arg).intValue() <= 5) {
			System.out.println("MyObserver2 count is :" + arg);
		}
	}

}
