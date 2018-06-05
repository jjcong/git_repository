package algorithm.test.exercise.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class tesy {

    public static void main(String[] args) {

        tesy tesy = new tesy();

    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        String word = removeRepetition(str);

        result = permutation(word, 0, word.length() - 1);

        return result;
    }

    public ArrayList<String> permutation(String str, int start, int end) {

        ArrayList<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        if (start == end) {
            String tmp = null;
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
            }
            result.add(sb.toString());
        } else {
            for (int i = start; i < str.length(); i++) {
                swap(str, i , start);
                permutation(str, start + 1, end);
                swap(str, i , start);
            }
        }
        return result;
    }

    public String removeRepetition(String str) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))) {
                sb.append(str.charAt(i));
                map.put(str.charAt(i), 1);
            }
        }
        return sb.toString();
    }

    public void swap(String str, int start, int end) {
        char[] chars = str.toCharArray();
        char tmp = chars[start];
        chars[start] =  chars[end];
        chars[end] = tmp;
    }
}
