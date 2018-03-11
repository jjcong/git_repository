package design.pattern.iterator;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 迭代器模式顺序访问聚集中的对象
 * @version V1.0.0
 */
public class IteratorTest {
	
	public static void main(String[] args) {
		
		Collection1 col =  new MyCollection();
		Iterator1 iter = (Iterator1) col.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
