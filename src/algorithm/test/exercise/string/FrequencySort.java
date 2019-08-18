package algorithm.test.exercise.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
    public  static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] bucket = new ArrayList[s.length() + 1];

        for (char key : map.keySet()) {
            int count = map.get(key);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }
        for (int i = s.length(); i > 0 ; i--) {
            if (bucket[i] != null) {
                for (Character num : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }


}
