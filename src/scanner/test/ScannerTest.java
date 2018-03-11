package scanner.test;

import java.util.Scanner;
/**
 * 
 * @author j_cong
 * @date 2017年8月26日
 * @describe 获取用户键盘的输入流,使用System.in
 * @version V1.0.0
 */
public class ScannerTest {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int y = sc.nextInt();
		System.out.println("x=" + y);
	}
	
	
}
