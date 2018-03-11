package collection.test.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * 
 * @author j_cong
 * @date 2017年8月27日
 * @describe 遍历LinkedList测试
 * @version V1.0.0
 */
public class TraverseLinkedListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("World");
		
		//方法一
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		System.out.println("---------------------");
		
		//方法二
		Iterator<String> iter1 = list.iterator();
		while (iter1.hasNext()) {
			String str = iter1.next();
			System.out.println(str);
		}
		System.out.println("---------------------");
		
		//方法三（方法二的变形）
		for (Iterator<String> iter2 = list.iterator();iter2.hasNext();) {
			String str = iter2.next();
			System.out.println(str);
		}
		System.out.println("---------------------");
		
		//方法四
		for (String s : list) {
			System.out.println(s);
		}
	}
}
