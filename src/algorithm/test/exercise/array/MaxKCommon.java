package algorithm.test.exercise.array;
/**
 * 数组中使用频率最高的K个数
 *
 * @author  j_cong
 * @date    2018/08/25
 * @version V1.0
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxKCommon {

    public static void main(String[] args) {
        MaxKCommon common = new MaxKCommon();
        int[] arr = {1,1,1,2,2,3};
        common.topKFrequent(arr, 2);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }

        for (int i = nums.length; i > 0; i--) {
            if (bucket[i] != null && res.size() < k) {
                res.addAll(bucket[i]);
            }
        }

        return res;
    }
}
