package collection.test.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
/**
 * @author j_cong
 * @date 2017年9月30日
 * @describe 遍历HashMap的测试程序。
 *   (01) 通过entrySet()去遍历key、value，参考实现函数：
 *        iteratorHashMapByEntryset()
 *   (02) 通过keySet()去遍历key、value，参考实现函数：
 *        iteratorHashMapByKeyset()
 *   (03) 通过values()去遍历value，参考实现函数：
 *        iteratorHashMapJustValues()
 * @version V1.0.0
 */
public class HashMapIteratorTest {
	
	public static void main(String[] args) {
		
		int val = 0;
		String key = null;
		Integer value = null;
		Random r = new Random();
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < 12; i++) {
			//随机产生一个[0,100)之间的数字
			val = r.nextInt(100);
			key = String.valueOf(value);
			value = r.nextInt(5);
			
			map.put(key, value);
			System.out.println("key: " + key + " value " + value);

		}
		
		
		//通过entrySet()遍历HashMap的key-value值
		iteratorHashMapByEntryset(map);
		
		//通过keySet()遍历HashMap的key-value值
		iteratorHashMapByKeyset(map);
		
		//遍历HashMap的value值
		iteratorHashMapJustValues(map);
		
		
	}
	
    /*
     * 通过entry set遍历HashMap
     * 效率高!
     */
	private static void iteratorHashMapByEntryset(HashMap map) {
		if (map == null) {
			return;
		}
		
		System.out.println("\niterator HashMap By entrySet");
		
		String key = null;
		Integer integ = null;
		Iterator<?> iter = map.entrySet().iterator();
		
		while (iter.hasNext()) {
			Map.Entry entry =  (Map.Entry) iter.next();
			
			key = (String)entry.getKey();
			integ = (Integer)entry.getValue();
			
			System.out.println(key + "--" + integ.intValue());
		}
	}
	
    /*
     * 通过keyset来遍历HashMap
     * 效率低!
     */
	private static void iteratorHashMapByKeyset(HashMap map) {
		
		if (map == null) {
			return ;
		}
		System.out.println("\niterator HashMap By keySet");
		
		String key = null;
		Integer integ = null;
		Iterator iter = map.keySet().iterator();
		
		while (iter.hasNext()) {
			key = (String)iter.next();
			integ = (Integer)map.get(key);
			
			System.out.println(key + "--" + integ.intValue());
		}
	}
	
    /*
     * 遍历HashMap的values
     */
	private static void iteratorHashMapJustValues(HashMap map) {
		
		if (map == null) {
			return;
		}
		
		System.out.println("\niterator HashMap By values");
		
		Collection c = map.values();
		Iterator iter = c.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
