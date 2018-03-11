package collection.test.list;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author j_cong
 * @date 2017年8月27日
 * @describe 将字符串数组转化为List数组
 * @version V1.0.0
 */
public class Array2ListTest {

	public static void main(String[] args) {
		
		String[] str = {"1","2","3"};
		List<String> list = Arrays.asList(str);
		System.out.println(list);
	}
}
