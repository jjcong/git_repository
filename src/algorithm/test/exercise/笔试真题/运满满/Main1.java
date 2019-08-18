package algorithm.test.exercise.笔试真题.运满满;
/**
 * 删除最少使用的单词
 *
 * @author  j_cong
 * @date    2018/09/20
 * @version V1.0
 */
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while(in.hasNext())
        {
            String inputString = in.next();
            char[] inputChar = inputString.toCharArray();
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char c : inputChar) {
                map.put(c, map.getOrDefault(c, 0));

            }
            Collection<Integer> values = map.values();
            int minIndex = Collections.min(values);
            StringBuffer sb = new StringBuffer();
            for (char keys : inputChar) {
                if(map.get(keys) != minIndex)
                {
                    sb.append(keys);
                }
            }
            System.out.println(sb);
        }
    }

}
