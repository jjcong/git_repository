package jvm.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author j_cong
 * @date 2017年10月16日
 * @describe VisualVM工具的BTrace功能跟踪演示
 * @version V1.0.0
 */
public class BTraceTest {

	public int add(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) throws IOException {
		
		BTraceTest test = new BTraceTest();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			reader.readLine();
			int a = (int)Math.round(Math.random() * 100);
			int b = (int)Math.round(Math.random() * 100);
			
			System.out.println(test.add(a, b));
		}
	}
}
