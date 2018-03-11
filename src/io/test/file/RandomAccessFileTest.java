package io.test.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * 随机访问文件测试，默认ISO 8857-7编码，打开后可能有乱码
 * 
 * @author  j_cong
 * @date    2018/03/06
 * @version V1.0
 */
public class RandomAccessFileTest {
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "D:" + File.separator + "eyelake.txt";
		File f = new File(fileName);
		RandomAccessFile demo = new RandomAccessFile(f, "rw");
		
		demo.writeBytes("abcsef");
		demo.writeInt(12);
		demo.writeBoolean(true);
		demo.writeChar('A');
		demo.writeFloat(1.21f);
		demo.writeDouble(12.123);
		demo.close(); 
	}

}
