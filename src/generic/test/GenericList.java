package generic.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author j_cong
 * @date 2017年8月27日
 * @describe ArrayList测试
 * @version V1.0.0
 */
public class GenericList {

	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
		strList.add("Hello");
		strList.add("World");
		
//		strList.foreach(str -> System.out.println(str.length()));
		for(String str:strList) {
			System.out.println(str);
		}
	}
}
