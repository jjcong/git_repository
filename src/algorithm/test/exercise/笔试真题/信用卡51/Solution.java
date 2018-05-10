package algorithm.test.exercise.笔试真题.信用卡51;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 判断A是否包含B
 * 
 * @author  j_cong
 * @date    2018/05/07
 * @version V1.0
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] res = str.split(";");
        String a = res[0];
        String b = res[1];
        System.out.println(contains(a, b));

    }

    public static boolean contains(String str1, String str2) {


        if (str2 == null) {
            return true;
        }
        if (str1 == null) {
            return false;
        }
        char[] aChars = str1.toCharArray();
        char[] bChars = str2.toCharArray();

        List<Character> aList = new ArrayList<>();
        for (char a : aChars) {
            aList.add(a);
        }

        List<Character> bList = new ArrayList<>();
        for (char b : bChars) {
            bList.add(b);
        }

        int index;
        for (int i = bList.size() - 1; i >= 0; i--) {
            index = aList.indexOf(bList.get(i));
            if (index != -1) {
                bList.remove(i);
                aList.remove(index);
            } else {
                return false;
            }
        }
        return true;
    }
}
