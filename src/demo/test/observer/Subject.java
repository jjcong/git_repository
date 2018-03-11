package demo.test.observer;

import java.util.Observable;

public class Subject extends Observable {
	
	void counter(int number) {
		
		for (; number >= 0; number--) {
			
			this.setChanged();
			this.notifyObservers(number);
		}
	}
}
