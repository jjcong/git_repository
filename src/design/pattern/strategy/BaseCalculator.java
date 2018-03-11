package design.pattern.strategy;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 策略模式：抽象类，提供辅助方法
 * @version V1.0.0
 */
public abstract class BaseCalculator {
	
	public int[] split(String exp, String opt) {
		
		String[] array = exp.split(opt);
		int[] arrayInt = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		
		return arrayInt;
	}

}
