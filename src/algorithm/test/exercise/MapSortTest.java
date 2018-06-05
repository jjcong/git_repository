package algorithm.test.exercise;

import java.util.*;

public class MapSortTest {


    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("A", 4);
        map.put("C", 1);
        map.put("B", 1);
        map.put("D", 2);
        map.put("F", 3);
        map.put("E", 4);

        System.out.println("对HashMap实现的Map进行Value排序并打印：");

        List<Map.Entry<String, Integer>> list = rankMapByValue(map, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println("Key : " + entry.getKey() + " , Value : " + entry.getValue());
        }

    }

    public static List<Map.Entry<String, Integer>> rankMapByValue(Map<String, Integer> map, final Comparator<Integer> valueComparator) {

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return valueComparator.compare(o1.getValue(), o2.getValue());
            }
        });

        return list;
    }

}
