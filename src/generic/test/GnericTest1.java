package generic.test;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;


/**
 * 
 * @author j_cong
 * @date 2017年8月25日
 * @describe 泛型与反射测试
 * @version V1.0.0
 */

public class GnericTest1 {
	@ Test
	public void genericTest() {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("njupt");
		Class c = arr.getClass();
		try {
			Method method = c.getMethod("add", Object.class);
			method.invoke(arr, 100);
			System.out.println(arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
