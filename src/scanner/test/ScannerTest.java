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
		int n = sc.nextInt();
		//必须清除当前行的标志
		sc.nextLine();

		StringBuilder sb = new StringBuilder();

		for  (int i = 0; i < n; i++) {
            if (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append(" ");
            }
        }

		System.out.println(sb.toString());
	}
	
	
}
