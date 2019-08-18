package algorithm.test.exercise.笔试真题.中国电信;

import java.util.ArrayList;
import java.util.Map;
import java.util.*;
/**
 * 删除字符串中出现次数最少的字符
 *
 * @author  j_cong
 * @date    2018/09/10
 * @version V1.0
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] ch = str.toCharArray();
            Map<Character, Integer> map = new TreeMap<>();
            for (int i = 0; i < ch.length; i++) {
                map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
            }
            int number = Integer.MAX_VALUE;
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < ch.length; i++) {
                if (map.get(ch[i]) < number) {
                    number = map.get(ch[i]);
                    list.clear();
                    list.add(ch[i]);
                } else if (map.get(ch[i]) == number) {
                    list.add(ch[i]);
                }
            }
            for (char c : list) {
                str = str.replace(String.valueOf(c), "");
            }
            System.out.println(str);
        }
        sc.close();
    }

}
