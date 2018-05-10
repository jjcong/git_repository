package algorithm.test.exercise;

import java.util.*;

/**
 * 分别实现根据Map的key和value进行排序
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/05/03
 */
public class MapUtils {

    public static void main(String[] args) {

        // 使用HashMap实现
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("D", 1);
        hashMap.put("C", 2);
        hashMap.put("A", 3);
        hashMap.put("B", 2);
        hashMap.put("F", 1);
        hashMap.put("E", 0);

        List<Map.Entry<String,Integer>> list = new ArrayList<>();

        System.out.println("对HashMap实现的Map进行Value排序并打印：");
        rankMapByValue(hashMap, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return Integer.compare(o1, o2);
            }
        });

        System.out.println();

        // 使用LinkedHashMap实现
        Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        linkedHashMap.put("D", 1);
        linkedHashMap.put("C", 2);
        linkedHashMap.put("A", 3);
        linkedHashMap.put("B", 2);
        linkedHashMap.put("F", 1);
        linkedHashMap.put("E", 0);

        System.out.println("对LinkedHashMap实现的Map进行Value排序并打印：");
        rankMapByValue(linkedHashMap, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return Integer.compare(o1, o2);
            }
        });

        System.out.println("\n--------我是分割线--------\n");

        System.out.println("对Map进行Key排序并打印：");
        rankMapByKey(hashMap, String.CASE_INSENSITIVE_ORDER);  // String的一个排序算子

        System.out.println("\n--------我是分割线--------\n");

        System.out.println("HashMap是不保持插入顺序的，是无序的：");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " , Value : "
                    + entry.getValue());
        }

        System.out.println();

        System.out.println("LinkedHashMap是保持插入顺序的：");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " , Value : "
                    + entry.getValue());
        }
    }


    /**
     * @param map           待排序的Map
     * @param keyComparator Key的排序规则
     * @description 根据Key对Map进行排序，并将每条Map.Entry按序输出
     * @author rico
     * @created 2017年5月11日 上午9:14:10
     */
    public static <K, V> void rankMapByKey(Map<K, V> map, final Comparator<K> keyComparator) {

        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return keyComparator.compare(o1.getKey(), o2.getKey());
            }
        });

        for (Map.Entry<K, V> entry : list) {
            System.out.println("Key :" + entry.getKey() + "," + "Value :" + entry.getValue());
        }
    }

    /**
     * @param map             待排序的Map
     * @param valueComparator Value的排序规则
     * @description 根据Value对Map进行排序，并将每条Map.Entry按序输出
     * @author rico
     * @created 2017年5月11日 上午9:14:10
     */

    public static <K, V> void rankMapByValue(Map<K, V> map,
                                             final Comparator<V> valueComparator) {
        List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>(
                map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return valueComparator.compare(o1.getValue(), o2.getValue());
            }
        });

        for (Map.Entry<K, V> entry : list) {
            System.out.println("Key : " + entry.getKey() + " , Value : "
                    + entry.getValue());
        }
    }
}
