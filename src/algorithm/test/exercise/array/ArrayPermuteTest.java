package algorithm.test.exercise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组全排列
 *
 * @author  j_cong
 * @date    2018/04/01
 * @version V1.0
 */
public class ArrayPermuteTest {

    public static void main(String[] args) {

        ArrayPermuteTest test = new ArrayPermuteTest();
        int[] arr = {1, 2, 3};

        test.permute(arr);
    }

    List<List<Integer>> result = new ArrayList<>();

    public  List<List<Integer>> permute(int[] nums) {
        // write your code here
        int start = 0;
        int end = nums.length - 1;

        if (nums == null || nums.length == 0) {
            return null;
        }
         result = permute(nums, start, end);


        return result;
    }

    public  List<List<Integer>> permute(int[] nums, int start, int end) {

        if (start  == end) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i <= end; i++) {
                tmp.add(nums[i]);
            }
            result.add(tmp);

        } else {
            for (int j = start; j <= end; j++) {
                swap(nums, j, start);
                permute(nums, start + 1, end);
                swap(nums, j, start);
            }
        }

        return result;
    }

    public static void swap(int[] nums, int num1, int num2) {
        int tmp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = tmp;
    }

}
