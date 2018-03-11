package design.pattern.interpreter;

/**
 * @author j_cong
 * @date 2017年8月31日
 * @describe 解释器模式：加法
 * @version V1.0.0
 */
public class Plus implements Expression {

	@Override
	public int interpret(Context context) {
		return context.getNum1() + context.getNum2();
	}

}
