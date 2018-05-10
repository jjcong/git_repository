package algorithm.test.exercise;

import java.util.*;

/**
 * 根据map的value进行升序排序
 *
 * @author  j_cong
 * @date    2018/05/07
 * @version V1.0
 */
public class SortByValueTest {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(7, 7);
        map.put(6, 6);
        map.put(5, 5);
        map.put(4, 4);
        map.put(3, 3);
        map.put(2, 2);
        map.put(1, 1);

        Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, valueComparator);

        for (Map.Entry i : list) {
            System.out.println(i.getKey() + " " + i.getValue());
        }
    }


}
