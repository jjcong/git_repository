package design.pattern.visitor;

/**
 * @author j_cong
 * @date 2017年8月30日
 * @describe 访问者模式：定义一个访问者接口
 * @version V1.0.0
 */
public interface Visitor {
	
	void visit(Subject sub);

}
