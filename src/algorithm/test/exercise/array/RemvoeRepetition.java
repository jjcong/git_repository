package algorithm.test.exercise.array;

import java.util.*;

public class RemvoeRepetition {

    public static void main(String[] args) {

        int[] arr = {4, 5, 3, 4};
        String str1 = "hello";
        String str2 = "ll";
        removeElement1(arr, 4);
        System.out.println(strStr(str1, str2));
    }

    public  static int removeElement(int[] A, int elem) {

        List<Integer> list = new LinkedList<>();
        for (int i : A) {
            if (i != elem) {
                list.add(i);
            }
        }

        A = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            A[i] = list.get(i);
        }

        return A.length;
    }

    public  static int removeElement1(int[] A, int elem) {

        int cnt = 0;

        for (int ele : A) {
            if (elem != ele) {
                A[cnt++] = ele;
            }
        }
        return cnt;

    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        int res = -1;
        if (haystack.contains(needle)) {
            res = haystack.indexOf(needle);
        }
        return res;
    }


}
