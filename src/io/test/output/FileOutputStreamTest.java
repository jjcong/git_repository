package io.test.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
/**
 * 字节输出流OutputStream测试,输入输出的主对象为内存
 *
 * @author  j_cong
 * @date    2017/10/02
 * @version V1.0
 */
public class FileOutputStreamTest {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] bbuf = new byte[32];
		int hasRead = 0;
		
		try {
		    fis = new FileInputStream("E:/PrintBooleanMatrix/Person.java");
		    //如果没有NewPerson.java 则会创建一个
		    fos = new FileOutputStream("E:/PrintBooleanMatrix/NewPerson.java");
		    
		    while ((hasRead = fis.read(bbuf)) > 0) {
		    	fos.write(bbuf, 0, hasRead);
		    }
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
