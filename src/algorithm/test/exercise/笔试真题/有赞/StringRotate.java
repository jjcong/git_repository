package algorithm.test.exercise.笔试真题.有赞;

import java.util.Scanner;

public class StringRotate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(";");
        System.out.println(rotateString(strs[0], strs[1]));

    }

    public static boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A+A).contains(B);
    }

}
