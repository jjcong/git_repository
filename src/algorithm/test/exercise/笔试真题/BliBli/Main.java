package algorithm.test.exercise.笔试真题.BliBli;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        String[] strs = input[0].split(" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        System.out.println(sum(arr, Integer.valueOf(strs[1])));

    }


    public static String threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                if (nums[low] + nums[high] + nums[i] == target) {
                    if (!hashSet.contains(Arrays.asList(nums[i], nums[low], nums[high]))) {
                        hashSet.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        return "True";
                    }

                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;

                    low++;
                    high--;
                } else if (nums[low] + nums[high] + nums[i] > target) {
                    high--;
                } else {
                    low++;
                }

            }
        }

        return "False";
    }


    public static String sum(int[] arr, int target) {
        if (arr.length < 3) return "False";
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        return "True";
                    }
                }
            }
        }
        return "False";
    }


}
