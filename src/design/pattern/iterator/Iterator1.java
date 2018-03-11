package design.pattern.iterator;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 迭代器模式：自定义类Iterator，迭代器对象
 * @version V1.0.0
 */
public interface Iterator1 {
	
	//前移
	Object previous();
	
	//后移
	Object next();
	boolean hasNext();
	
	//取得第一个元素
	Object first();

}
