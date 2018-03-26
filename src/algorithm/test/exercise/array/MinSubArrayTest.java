package algorithm.test.exercise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组中最小子数组的和
 *
 * @author  j_cong
 * @date    2018/03/26
 * @version V1.0
 */
public class MinSubArrayTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(-4);

        minSubArray(list);

    }

    public static int minSubArray(List<Integer> nums) {
        // write your code here
        int sum = nums.get(0);
        int t = sum;

        for (int i = 1; i < nums.size() - 1; i++) {
            if (t > 0) {
                t = 0;
            }
            t += nums.get(i);

            if (t < sum) {
                sum = t;
            }
        }

        return sum;
    }
}
