package design.pattern.interpreter;

/**
 * @author j_cong
 * @date 2017年8月31日
 * @describe 解释器模式：表达式接口
 * @version V1.0.0
 */
public interface Expression {
	
	int interpret(Context context);

}
