package scanner.test;

import java.util.Scanner;
/**
 * @author j_cong
 * @date 2017年10月2日	
 * @describe 使用Scanner获取键盘输入
 * @version V1.0.0
 */
public class ScannerKeyBoardTest {

	public static void main(String[] args) {
		 
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			System.out.println("键盘输入的内容是：" + sc.next());
		}
			
	}
}
