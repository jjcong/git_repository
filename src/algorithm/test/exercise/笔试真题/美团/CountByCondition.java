package algorithm.test.exercise.笔试真题.美团;

import java.util.*;
/**
 * 作者：WAK
 * 链接：https://www.nowcoder.com/discuss/104554?type=2&order=0&pos=53&page=1
 * 来源：牛客网
 *
 * 小明拿到了一个数列a1 , a2 , ... an ，小明想知道存在多少个区间[l,r]同时满足下列两个条件：
 * 1、r-l+1=k;
 * 2、在a l , a l+1,...ar中，存在一个数至少出现了 t 次。
 *
 * @author  j_cong
 * @date    2018/09/07
 * @version V1.0
 */
public class CountByCondition {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getArray(arr, k, t));
    }

    public static int getArray(int[] arr, int k, int count) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + k <= arr.length) {
                List<Integer> list = new ArrayList<>();
                for (int j = i; j < i + k; j++) {
                    list.add(arr[j]);
                }
                if (getCount(list, count)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static boolean getCount(List<Integer> list, int count) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) >= count) {
                return true;
            }
        }
        return  false;
    }
}
