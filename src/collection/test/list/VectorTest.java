package collection.test.list;

import java.util.Vector;
import java.util.Enumeration;
/**
 * 
 * @author j_cong
 * @date 2017年8月27日
 * @describe Vector容器测试,线程安全
 * @version V1.0.0
 */
public class VectorTest {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		v.add("123");
		v.add("Hello");
		v.add("World");
		
		Enumeration<String> e = v.elements();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
	
}
