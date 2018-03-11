package io.test.input;

import java.io.FileInputStream;
import java.io.IOException;
/**
 * @author j_cong
 * @date 2017年10月2日
 * @describe 字节输入流InputStream测试
 * @version V1.0.0
 */
public class FileInputStreamTest  {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		byte[] bbuf = new byte[100];
		int hasRead = 0;
		
		try{
		    fis = new FileInputStream("E:/PrintBooleanMatrix/Person.java");

		    //每次读取指定buff字节，后台调用readBytes(b, 0, b.length)
			while ((hasRead = fis.read(bbuf)) > 0) {
				System.out.println(new String(bbuf, 0 ,hasRead));
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if (null != fis) {
				try {
					fis.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
