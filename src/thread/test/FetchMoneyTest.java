package thread.test;

public class FetchMoneyTest {

	public static void main(String[] args) {
		
		Bank bank = new Bank();
		
		Thread t1 = new MoneyThread(bank); //柜台
		Thread t2 = new MoneyThread(bank); //ATM
		
		t1.start();
		t2.start(); 
		
	}
}


class Bank {
	
	private int money = 1000;
	
	public synchronized int getMonery (int number) {
		
		if (number < 0) {
			return -1;
		} else if (number > money) {
			return -2;
		} else if (money < 0) {
			return -3;
		} else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			money -= number;
			System.out.println("剩余金额：" + money);
			
			return number; 
		}
		
	}
}
 class MoneyThread extends Thread {
	 
	 private Bank bank;
	 
	 public MoneyThread (Bank bank) {
		 
		 this.bank = bank;
	 }
	 public void run() {
		 System.out.println(bank.getMonery(800));
	 }
 }