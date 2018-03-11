package design.pattern.visitor;

/**
 * @author j_cong
 * @date 2017年8月30日
 * @describe 访问者模式：访问者接口实现类
 * @version V1.0.0
 */
public class MyVisitor implements Visitor {

	@Override
	public void visit(Subject sub) {

		System.out.println("visit the subject！" + sub.getSubject());
	}

}
