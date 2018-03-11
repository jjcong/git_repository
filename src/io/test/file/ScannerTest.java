package io.test.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) {
		
		File file = new File("D:" + File.separator + "eyelake.txt");
		Scanner sca = null;
		
		try {
			sca = new Scanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String str = sca.next();
		System.out.println("从文件中读取的内容是：" + str);
	}

}
