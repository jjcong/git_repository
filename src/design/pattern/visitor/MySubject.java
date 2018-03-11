package design.pattern.visitor;

/**
 * @author j_cong
 * @date 2017年8月31日
 * @describe 访问者模式：Subject实现类，accept方法，接受将要访问它的对象，getSubject()获取将要被访问的属性，
 * @version V1.0.0
 */
public class MySubject implements Subject {

	@Override
	public void accept(Visitor visitor) {

		visitor.visit(this);
	}

	@Override
	public String getSubject() {
		return "love";
	}

}
