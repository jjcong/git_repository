package design.pattern.visitor;

/**
 * @author j_cong
 * @date 2017年8月31日
 * @describe 访问者模式：Subject类，accept方法，接受将要访问它的对象，getSubject()获取将要被访问的属性，
 * @version V1.0.0
 */
public interface Subject {
	
	void accept(Visitor visitor);
	String getSubject();

}
