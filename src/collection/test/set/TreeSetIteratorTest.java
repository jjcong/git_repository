package collection.test.set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
/**
 * @author j_cong
 * @date 2017年10月2日
 * @describe TreeSet遍历方式,推荐使用Iterator方式!!!
 * @version V1.0.0
 */
public class TreeSetIteratorTest {

	public static void main(String[] args) {
		
		TreeSet<String> set = new TreeSet<>();
		
		set.add("aaa");
		set.add("aaa");
		set.add("bbb");
		set.add("eee");
		set.add("ddd");
		set.add("eee");
		
		
		//顺序遍历TreeSet
		ascIteratorThroughIterator(set);
		//逆序遍历TreeSet
		descIteratorThroughIterator(set);
		//通过for-each遍历TreeSet。不推荐！此方式需要先将Set转换为数组
		foreachTreeSet(set);
		
	}
    // 顺序遍历TreeSet
	public static void ascIteratorThroughIterator(TreeSet<String> set) {
		System.out.printf("\n ---- Ascend Iterator ----\n");
		for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
			System.out.printf("asc : %s\n", iter.next());
		}
	}
	
    // 逆序遍历TreeSet
	public static void descIteratorThroughIterator(TreeSet<String> set) {
		System.out.printf("\n ---- Descend Iterator ----\n");
		for (Iterator<String> iter = set.descendingIterator(); iter.hasNext();) {
			System.out.printf("desc : %s\n", iter.next());
		}
	}
	
	//通过for-each遍历TreeSet。不推荐！此方式需要先将Set转换为数组
	private static void foreachTreeSet(TreeSet<String> set) {
		System.out.printf("\n ---- For--Each ----\n");
		for (String str : set) {
			System.out.printf("for-each : %s\n", str);
		}
	}
}
