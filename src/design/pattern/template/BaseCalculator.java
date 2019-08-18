package design.pattern.template;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 模板方法模式：抽象类,父类定义了方法执行的骨架，具体方法由子类去实现
 * @version V1.0.0
 */
public abstract class BaseCalculator {
	
	//主方法，实现对本类其他方法的调用
	public final int calculate(String exp, String opt) {
		int[] array = split(exp, opt);
		
		return calculate(array[0], array[1]);
	}
	
	//被子类重写的方法
	abstract public int calculate(int num1, int num2);
	
	public int[] split(String exp, String opt) {
		
		String[] array = exp.split(opt);
		int[] arrayInt = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		
		return arrayInt;
	}
	

}
