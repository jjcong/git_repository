package algorithm.test.exercise.array;

import java.util.*;

/**
 * 数组组成的最小数字（String表示）
 *
 * @author  j_cong
 * @date    2018/10/02
 * @version V1.0
 */
public class MinStringInArray {
    public static void main(String[] args) {
        int[] arr = {4,43,432,4321};
        System.out.println(minString(arr));
    }

    private static String minString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        List<String> list =  new LinkedList<>();
        for(int num : arr) {
            list.add(num + "");
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("o1 = " + o1 + ",o2 = "+o2+",o1 + o2=" + (o1 + o2));
                System.out.println("o1 = " + o1 + ",o2 = "+o2+",o2 + o1=" + (o2 + o1));
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        for(String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
