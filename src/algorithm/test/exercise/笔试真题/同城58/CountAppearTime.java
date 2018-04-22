package algorithm.test.exercise.笔试真题.同城58;

import java.util.*;

/**
 * 统计给定字符串中字母出现的次数，输出出现次数最多的前三个
 *
 * @author  j_cong
 * @date    2018/04/15
 * @version V1.0
 */
public class CountAppearTime {

    public static void main(String[] args) {
        String str = "aaabbbcceee";
        String res = count3(str, 3);
        System.out.println(res);

    }

    public static String count3(String str, int k) {

        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for ( Character word : chars) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Character>[] bucket = new ArrayList[chars.length + 1];

        for (Character key : map.keySet()) {
            int fre = map.get(key);
            if (bucket[fre] == null) {
                bucket[fre] = new ArrayList<>();
            }
            bucket[fre].add(key);
        }

        StringBuilder sb = new StringBuilder();
        List<Character> res = new ArrayList<>();

        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    if (res.size() < k) {
                        res.add(bucket[i].get(j));
                    }
                }
            }
        }

        for (Character word : res) {
            sb.append(word);
        }

        return sb.toString();
    }

    public void FindNumsAppearOnce(int [] array, int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        for (Integer num : map.keySet()) {
            if (map.get(num) == 1) {
                if (num1[0] == 0) {
                    num1[0] = num;
                } else {
                    num2[0] = num;
                }
            }
        }
    }
}
