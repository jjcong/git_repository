package io.test.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class OutputTest {
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "D:" + File.separator + "eyelake.txt";
		File f = new File(fileName);
		Writer out = new FileWriter(f);
		
		String str = "Hello World!";
		out.write(str);
		out.close();
		
	}

}
