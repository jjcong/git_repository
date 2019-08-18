package algorithm.test.exercise.笔试真题.携程;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LRUCache {

    public static class LRULinkedMap {

        private int cacheSize;
        private LinkedHashMap cacheMap;

        private LRULinkedMap(int cacheSize) {
            this.cacheSize = cacheSize;
            cacheMap = new LinkedHashMap(16, 0.75F, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return cacheSize + 1 == cacheMap.size();
                }
            };
        }

        public void put(int key, int value) {
            cacheMap.put(key, value);
        }

        public int get(int key) {

            if (cacheMap.containsKey(key)) {
                return (int)cacheMap.get(key);
            }

            return -1;
        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String initCapacity = scanner.nextLine();
        LRULinkedMap map = new LRULinkedMap(Integer.valueOf(initCapacity));

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] strs = input.split(" ");

            if ("p".equals(strs[0])) {
                map.put(Integer.valueOf(strs[1]), Integer.valueOf(strs[2]));
            }

            if ("g".equals(strs[0])) {
                System.out.println(map.get(Integer.valueOf(strs[1])));
            }

        }

    }


}
