package design.pattern.strategy;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 策略模式：减法操作
 * @version V1.0.0
 */
public class Minus extends BaseCalculator implements ICalculator {

	@Override
	public int calculate(String exp) {
		
		int[] arrayInt = split(exp, "\\-");
		
		return arrayInt[0] - arrayInt[1];
	}

}
