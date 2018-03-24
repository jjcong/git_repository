package algorithm.test.exercise;

/**
 * @author:xudajan
 * @date:2018/3/16
 */
import java.util.*;
public class Rearrangement {
    public ArrayList<String> rearrangement(String str) {

        ArrayList<String> list = new ArrayList<>();
        char[] c = str.toCharArray();
        String result = "";
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < c.length; i++) {
            if (!set.contains(c[i])) {
                result += c[i];
                set.add(c[i]);
            }
        }
        char[]  result1 = str.toCharArray();
        for (int p = result1.length - 1; p > 0; p--) {
            for (int i = 0; i < p; i++) {
                char tmp = result1[i];
                result1[i] = result1[i + 1];
                result1[i + 1] = tmp;

            }
        }
        return list;
    }

}
