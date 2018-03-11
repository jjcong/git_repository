package collection.test.list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author j_cong
 * @date 2017年9月3日
 * @describe Linkedlist测试，不建议这样使用！！！
 * @version V1.0.0
 */
public class LinkedListTest {
	public static void main(String[] args) {
		
		List<Object> link = new LinkedList<>();
		link.add(123);
		link.add("double");
		link.add(8.8);
		link.add("float");
		link.add(520);
		
		printList(link);
		printReversedList(link);
	}
	
	private static void printList(List<Object> link) {
		System.out.println("正序链表中的元素");
		ListIterator<Object> li = link.listIterator();
		
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
		}
		System.out.println();
	}
	
	
	private static void printReversedList(List<Object> link) {
		System.out.println("逆序链表中的元素");
		ListIterator<Object> li = link.listIterator(link.size());
		
		while (li.hasPrevious()) {
			System.out.print(li.previous() + " ");
		}
		System.out.println();
	}
}
