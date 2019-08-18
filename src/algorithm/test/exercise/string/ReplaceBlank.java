package algorithm.test.exercise.string;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReplaceBlank {

    public static void main(String[] args) {
        String str = "hello world";
        int len = replaceBlank(str.toCharArray());
        System.out.println(len);
    }

    public static int replaceBlank(char[] string) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (char c : string) {
            if (' ' == c) {
                sb.append('%').append('2').append('0');
            } else {
                sb.append(c);
            }
        }
        return sb.length();

    }


}
