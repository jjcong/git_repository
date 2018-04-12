package scanner.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        char[] chars = str.toCharArray();
        int count = chars.length;

        if (isHuiWen(chars)) {
            count++;
        }

        for (int i = 0; i < chars.length; i++) {

            for (int k = i + 1; k < chars.length; k++) {
                char[] chars1 = delete(chars, i, k);

                if (isHuiWen(chars1)) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }


    public static boolean isHuiWen(char[] source) {

        if (source == null || source.length == 0) {
            return false;
        }
        int start = 0;
        int end = source.length - 1;

        while (start <= end) {
            if (source[start] != source[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }


    public static char[] delete(char[] source, int start, int end) {

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < source.length; i++) {
            if (i < start || i > end) {
                list.add(source[i]);

            }
        }

        char[] newChar = new char[list.size()];

        for (int j = 0; j < list.size(); j++) {
            newChar[j] = list.get(j);
        }


        return newChar;
    }

}
