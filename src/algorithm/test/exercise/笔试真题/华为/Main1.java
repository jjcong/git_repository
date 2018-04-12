package algorithm.test.exercise.笔试真题.华为;

import java.util.Scanner;
import java.util.TreeMap;

public class Main1 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();

        TreeMap<Character, Integer> map = new TreeMap<>();
        int max = 1;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 1);
            } else {
                int count = map.get(chars[i]);
                count++;
                max = max > count ? max : count;
                map.put(chars[i], count);
            }
        }
        for (int i = 0; i < max; i++) {
            for (Character key : map.keySet()) {
                int count = map.get(key);
                if (count > 0) {
                    stringBuffer.append(key);
                    count--;
                    if (count <= 0) {
                        map.put(key, 0);
                    } else {
                        map.put(key, count);
                    }
                }
            }
        }
        System.out.println(stringBuffer.toString());
    }
}
