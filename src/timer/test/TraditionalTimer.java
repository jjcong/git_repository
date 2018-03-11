package timer.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @ Author:  j_cong
 * @ Date:    2017年11月22日
 * @ Version: V1.0.0
 * @ Desc:    定时器的使用,每隔2S爆炸一次
 */
public class TraditionalTimer {
	
	public static void main(String[] args) {  
		
		  class MyTimerTask extends TimerTask {

				@Override
				public void run() {
					System.out.println("Bombing.......");
					new Timer().schedule(new MyTimerTask(), 2000);
				}
			   }
				
		new Timer().schedule(new MyTimerTask(), 2000);  
		
		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
