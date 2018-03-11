package design.pattern.iterator;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 迭代器模式：自定义类Collection，需要遍历的对象
 * @version V1.0.0
 */
public interface Collection1 {
	
	Iterator1 iterator();
	
	//取得集合元素
	Object get(int i);
	
	//取得集合大小
	int size();

}
