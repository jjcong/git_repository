package design.pattern.template;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 模板方法模式：测试
 * @version V1.0.0
 */
public class TemplateTest {
	
	public static void main(String[] args) {
		
		String exp = "8+8";
		BaseCalculator cal = new Plus();
		int result = cal.calculate(exp, "\\+");
		
		System.out.println(result);
	}

}
