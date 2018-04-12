package scanner.test;
import java.util.Scanner;

public class Main3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        String[] tests = new String[num];
        for (int i = 0; i < num; i++) {
            tests[i] = scanner.nextLine();
        }
        for (int i = 0; i < num; i++) {
            testIfSatisfy(tests[i]);
        }
    }

    private static void testIfSatisfy(String str) {

        char[] chaStr = str.toCharArray();
        System.out.println(calculate(chaStr));
    }

    private static String calculate(char[] cha) {
        String result = "Yes";
        int left = 0;
        int right = 0;
        for (int i = 0; i < cha.length; i++) {
            if (cha[i] == ')') {
                right++;
            } else {
                left++;
            }
            if ((i + 1) % 2 == 0) {
                if (right >= left + 1) {
                    result = "No";
                    return result;
                }
            }
        }
        if (left != right) {
            result = "No";
            return result;
        }
        return result;
    }
}


