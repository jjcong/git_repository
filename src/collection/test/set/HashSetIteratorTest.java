package collection.test.set;

import java.util.HashSet;
import java.util.Iterator;
/**
 * @author j_cong
 * @date 2017年10月2日
 * @describe HashSet的遍历方法，推荐使用Iterator方式
 * @version V1.0.0
 */

public class HashSetIteratorTest {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < 5; i++) {
			set.add("" + i);
		}

		//通过Iterator遍历HashSet,推荐使用！！！
		iteratorHashSet(set);
		
		//通过for-each遍历HashSet
		foreachHashSet(set);
		
	}
	
    /*
     * 通过Iterator遍历HashSet。推荐方式
     */
	private static void iteratorHashSet(HashSet<String> set) {
		
		for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
			System.out.printf("iterator : %s\n",iter.next());
		}
	}
	
    /*
     * 通过for-each遍历HashSet。不推荐！此方法需要先将Set转换为数组
     */
	private static void foreachHashSet(HashSet<String> set) {
		
		String[] arr = (String[]) set.toArray(new String[0]);
		for (String str : arr) {
			System.out.printf("for each : %s\n", str);
		}
	}
	
}
