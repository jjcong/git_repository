package design.pattern.iterator;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 迭代器模式：定义一系列迭代操作，且持有Collection1的实例
 * @version V1.0.0
 */
public class MyIterator implements Iterator1 {
	
	private Collection1 collection;
	private int pos = -1;
	
	public MyIterator(Collection1 collection) {
		this.collection = collection;
	}

	@Override
	public Object previous() {
		if (pos > 0) {
			pos--;
		}
		return collection.get(pos);
	}

	@Override
	public Object next() {
		if (pos < collection.size() - 1) {
			pos++;
		}
		return collection.get(pos);
	}

	@Override
	public Object first() {
		pos = 0;
		return collection.get(pos);
	}

	@Override
	public boolean hasNext() {
		if (pos < collection.size() - 1) {
			return true;
		} else {
			return false;
		}
	}

}
