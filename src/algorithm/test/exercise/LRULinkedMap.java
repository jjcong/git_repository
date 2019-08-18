package algorithm.test.exercise;

/**
 * 使用LinkedHashMap实现LRU算法,重点是removeEldestEntry,
 * 重写该方法，用于删除链表中最先加入的元素，每次get时，将
 * 元素放于链表头
 *
 * @author j_cong
 * @date 2018/08/04
 * @version V1.0
 */
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedMap<K, V> {

    private int cacheSize;
    private LinkedHashMap<K, V> cacheMap;

    private LRULinkedMap(int cacheSize) {
        this.cacheSize = cacheSize;

        cacheMap = new LinkedHashMap<K, V>(16, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {

                return cacheSize + 1 == cacheMap.size();
            }

        };
    }

    public void put(K key, V value) {
        cacheMap.put(key, value);
    }

    public V get(K key) {

        if (cacheMap.containsKey(key)) {
            return cacheMap.get(key);
        }

        return null;
    }

    public ArrayList<Map.Entry<K, V>> getAll() {
        return new ArrayList<Map.Entry<K, V>>(cacheMap.entrySet());
    }


    public static void main(String[] args) {

        LRULinkedMap<String, Integer> map = new LRULinkedMap<>(3);
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);

        for (Map.Entry<String, Integer> e : map.getAll()) {
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }
        System.out.println();
        map.put("4", 4);

        for (Map.Entry<String, Integer> e : map.getAll()) {
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }

        Integer i = map.get("5");
        System.out.println();
        for (Map.Entry<String, Integer> e : map.getAll()) {
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }
    }
}


