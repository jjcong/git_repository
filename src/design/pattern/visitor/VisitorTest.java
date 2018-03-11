package design.pattern.visitor;

/**
 * @author j_cong
 * @date 2017年8月31日
 * @describe 访问者模式：访问者模式把数据结构和作用于结构上的操作解耦合，使得操作集合可相对自由地演化。
 *           简单来说，访问者模式就是一种分离对象数据结构与行为的方法，通过这种分离，
 *           可达到为一个被访问者动态添加新的操作而无需做其它的修改的效果
 * @version V1.0.0
 */
public class VisitorTest {
	
	public static void main(String[] args) {
		
		Visitor visitor = new MyVisitor();
		Subject sub = new MySubject();
		
		sub.accept(visitor);
	}
}
