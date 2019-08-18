package algorithm.test.exercise.笔试真题.中国电信;


import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        String a = strs[0];
        String b = strs[1];
        int len1 = a.length();
        int len2 = b.length();
        int maxLen = 0;
        int i = 0;
        if (len1 >= len2) {
            int start = len1 - len2;
            i = start;
        }
        for (; i < len1; i++) {
            int tempLen = len1 - i;
            String tempA = a.substring(i);
            String tempB = b.substring(0, tempLen);
            if (tempA.equals(tempB)) {
                if (tempLen > maxLen) {
                    maxLen = tempLen;
                    break;
                }
            }
        }
        System.out.println(maxLen);
    }

}
