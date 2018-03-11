package jvm.test;

/**
 * @author j_cong
 * @date 2017年10月17日
 * @describe 单分派、多分派
 * @version V1.0.0
 */
public class Dispatch {

	static class QQ {};
	static class _360 {};
	
	public static class Father {
		
		public void hardChoice(QQ arg) {
			System.out.println("facher choose qq");
		}
		public void hardChoice(_360 arg) {
			System.out.println("facher choose 360");
		}
	}
	
	public static class Son extends Father {
		
		public void hardChoice(QQ arg) {
			System.out.println("son choose qq");
		}
		public void hardChoice(_360 arg) {
			System.out.println("son choose 360");
		}
	}
	
	
	public static void main(String[] args) {
		
		Father father = new Father();
		Father son = new Son();
		
		father.hardChoice(new _360());
		son.hardChoice(new QQ());
		
	}
		
}
