package io.test.input;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamMakedTest {
	public static void main(String[] args) {
		writeToFile();
		readFromFile();
	}
	
	private static void readFromFile() {
		String fileName = "D:" + File.separator +"eyelake.txt";
		InputStream input = null;
		try {
			input = new BufferedInputStream(new FileInputStream(new File(fileName)));
			if (!input.markSupported()) {
				System.out.println("mark/reset not supported!");
				return;
			}
			int ch;
			int count = 0;
			boolean marked = false;
			
			while ((ch = input.read()) != -1)  {
				System.out.println("." + ch);
				if ((ch == 4) && !marked) {
					input.mark(10);
					marked = true;
				}
				if ((ch == 8) & count < 2 ) {
					input.reset();
					count++;
				}
			}
		} catch ( IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	private static void writeToFile() {
		String fileName = "D:" + File.separator +"eyelake.txt";
		OutputStream output = null;
		try {
			output = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
			
			byte[] b = new byte[20];
			for (int i = 0; i < 20; i++) {
				b[i] = (byte) i;
				
				output.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
	} finally {
		try {
			output.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	}
}
