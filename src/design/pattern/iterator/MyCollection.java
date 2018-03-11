package design.pattern.iterator;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 迭代器模式：定义集合中的一些操作
 * @version V1.0.0
 */
public class MyCollection implements Collection1 {
	
	public String[] string = {"A", "B", "C", "D", "E"};

	@Override
	public Iterator1 iterator() {
		return new MyIterator(this);
	}

	@Override
	public Object get(int i) {
		return string[i];
	}

	@Override
	public int size() {
		return string.length;
	}

}
