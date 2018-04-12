package algorithm.test.exercise;

/**
 * 二分查找，相同时，返回第一次出现的序号
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/04/01
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 8, 8, 8, 8, 10, 13, 14};

        int result = binarySearch(arr, 8);
        System.out.println(result);
    }


    public static int binarySearch(int[] nums, int target) {
        // write your code here
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                //考虑重复数字在mid处的情况
                while (mid > 0 && nums[mid - 1] == target) {
                    mid--;
                }
                return mid;

            }
        }

        return -1;

    }
}
