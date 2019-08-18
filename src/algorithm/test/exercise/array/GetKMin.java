package algorithm.test.exercise.array;

import java.util.*;

/**
 * 数组中最小的k个数
 * 
 * @author  j_cong
 * @date    2018/08/30
 * @version V1.0
 */
public class GetKMin {

    public ArrayList<Integer> getKmin(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > arr.length || k <= 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }


    /**
     * HashMap计数+桶排序
     * @param arr
     * @param k
     * @return
     */
    public List<Integer> topKFrequency(int[] arr, int k) {

        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[arr.length + 1];
        for (int key : map.keySet()) {
            int cnt = map.get(key);
            if (bucket[cnt] == null) {
                bucket[cnt] = new ArrayList<>();
            }
            bucket[cnt].add(key);
        }
        for (int i = arr.length; i > 0; i--) {
            if (bucket[i] != null && res.size() < k ) {
                res.addAll(bucket[i]);
            }
        }

        return res;
    }
}
