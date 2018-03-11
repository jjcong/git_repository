package io.test.file;

import java.io.File;

public class CreateFileTest {
	
	public static void main(String[] args) {
		File file = new File("jincong.txt");
		try {
			file.createNewFile();
			
			 System.out.println(File.separator); // 表示“\”
			 System.out.println(File.pathSeparator);  //表示;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
