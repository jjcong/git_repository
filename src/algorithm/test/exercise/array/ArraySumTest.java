package algorithm.test.exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 找出数组中三个数相加为0的所有list
 * 
 * @author  j_cong
 * @date    2018/05/19
 * @version V1.0
 */
public class ArraySumTest {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int cur = num[i];
            if (i > 0 && cur == num[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;

            while (left < right) {
                int sum = num[left] + num[right];
                if (sum + cur == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(num[left]);
                    list.add(num[right]);
                    res.add(list);

                    //跳过重复数字
                    while (left + 1 < right && num[left] == num[left + 1]) {
                        left++;
                    }
                    while(right - 1 > left && num[right] == num[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum + cur < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    /**
     * 返回三个数相加和最接近Target的值
     *
     * @param num
     * @param target
     * @return
     */
    public int threeSumClosest(int[] num, int target) {
        if (num == null) {
            return 0;
        }
        int length = num.length;
        int res = 0;
        if (length <= 3) {
            for (int tmp : num) {
                res += tmp;
            }
            return res;
        }
        Arrays.sort(num);
        res = num[0] + num[1] + num[2];

        for (int i = 0; i < length; i++) {
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int curSum = num[i] + num[left] + num[right];
                if (curSum == target) {
                    return curSum;
                } else if (curSum < target) {
                    left++;
                } else {
                    right--;
                }
                if (Math.abs(target - curSum) < Math.abs(target - res)) {
                    res = curSum;
                }
            }

        }
        return res;
    }

    /**
     * 返回四个数相加和等于Target的list
     *
     * @param num
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num.length < 4) {
            return res;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    int curSum = num[i] + num[j] + num[left] + num[right];
                    if (curSum == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[left]);
                        list.add(num[right]);
                        res.add(list);

                        while (left + 1 < right && num[left] == num[left + 1]) {
                            left++;
                        }
                        while (right - 1 > left && num[right] == num[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (curSum < target) {
                        left++;
                    } else {
                        right--;
                    }

                }
            }
        }
        return res;
    }
}
