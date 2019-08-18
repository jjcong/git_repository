package algorithm.test.exercise.笔试真题.爱奇艺;

import java.util.*;
/**
 * 数组排序
 * 
 * @author  j_cong
 * @date    2018/09/15
 * @version V1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();

        int[] food = new int[N];

        for (int i = 0; i < N ; i++) {
            food[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int j = 0; j < M; j++) {
            String[] tmp = sc.nextLine().split(" ");
            int a = "A".equals(tmp[0]) ? 1 : -1;
            int index = Integer.parseInt(tmp[1]) - 1;
            food[index] += a;
        }
        int target = food[P - 1];
        Arrays.sort(food);

        int i = food.length - 1;

        for (; i >= 0; i++) {
            if(food[i] == target) break;
        }
        if (i == 0 && food[i] != target) {
            System.out.println(-1);
        } else {
            System.out.println(food.length - 1);
        }


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
