package io.test.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author j_cong
 * @date 2017年8月23日
 * @describe 使用缓冲区从键盘上读入内容,不支持换行
 * @version V1.0.0
 */

public class BufferedReaderTest {

	public static void main(String[] args) {
	    //装饰者模式
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("请输入内容:");
		
		try {
			str = buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("您输入的内容是：" + str);
		
	}
}
