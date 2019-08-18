package collection.test.ConsisitHash;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayMap {

    private Node[] buckects;

    private static final int DEFAULT_SIZE = 10;

    private int size = 10;

    public SortArrayMap() {
        buckects = new Node[DEFAULT_SIZE];
    }

    public void add(Long key, String value) {
        checkSize(size + 1);
        Node node = new Node(key, value);
        buckects[size++] = node;
    }

    public void checkSize(int size) {
        if (size >= buckects.length) {
            int oldLen = buckects.length;
            int newLen = oldLen + (oldLen >> 1);
            buckects = Arrays.copyOf(buckects, newLen);
        }
    }

    public void sort() {
        Arrays.sort(buckects, 0, size, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1 != null && o2 != null) {
                    if(o1.key > o2.key) {
                        return 1;
                    }
                }
                return -1;

            }
        });
    }

    public String firstNodeValue(long key) {
        if (size == 0) {
            return null;
        }
        for(Node bucket : buckects) {
            if (bucket == null) {
                continue;
            }
            if (bucket.key >= key) {
                return bucket.value;
            }
        }

        return buckects[0].value;
    }

    public static void main(String[] args) {
        SortArrayMap map = new SortArrayMap();
        map.add(100L, "127.0.1.100");
        map.add(10L, "127.0.1.10");
        map.add(8L, "127.0.1.8");
        map.add(1000L, "127.0.1.1000");

        map.sort();
        System.out.println(map);
        String value = map.firstNodeValue(101);
        System.out.println(value);
    }
}
