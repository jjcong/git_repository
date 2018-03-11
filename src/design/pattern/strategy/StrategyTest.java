package design.pattern.strategy;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 策略模式：定义一系列封装后的算法，之间可以相互替换，算法的变化不会影响到使用算法的用户
 * @version V1.0.0
 */
public class StrategyTest {
	
	public static void main(String[] args) {
		String exp = "2-8";
		ICalculator cal = new Minus();
		int result = cal.calculate(exp);
		
		System.out.println(result);
	}

}
