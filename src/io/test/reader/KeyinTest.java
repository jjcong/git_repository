package io.test.reader;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * 利用InputStreamReader获取键盘输入，不能换行，默认输出键是Enter（13）
 *
 * @author  j_cong
 * @date    2017/10/03
 * @version V1.0
 */
public class KeyinTest {

	public static void main(String[] args) {
		try ( 
				//将System.in包装成Reader对象
				InputStreamReader reader = new InputStreamReader(System.in);
				//将普通的Reader包装成BufferedReader
				BufferedReader br = new BufferedReader(reader)
				)
				{
					String line = null;
					
					while ((line = br.readLine()) != null) {
						if (line.equals("exit")) {
							System.exit(1);
						}
						System.out.println("输入内容为：" + line);
					}
			
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
	}

}

