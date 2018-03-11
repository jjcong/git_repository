package design.pattern.template;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 模板方法模式：加法操作
 * @version V1.0.0
 */
public class Plus extends BaseCalculator {
	
	@Override
	public int calculate(int num1, int num2) {
		return num1 + num2;
	}
}

	

