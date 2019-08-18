package algorithm.test.exercise.笔试真题.快手;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(canPartition(arr));
    }

    public static int getSum(int[] arr) {
        Arrays.sort(arr);
        int formerSum = 0;
        int latterSum = 0;
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            formerSum += arr[start];
            latterSum += arr[end];

            if (formerSum < latterSum) {
                start++;
            } else {
                end--;
            }
        }
        return arr[arr.length - 1];

    }



        public static int canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums)
                sum += num;
            if (sum % 2 == 1)
                return nums[nums.length - 1];
            else {
                sum /= 2;
                int n = nums.length;
                // dp[i][j] 表示 如果我们取前i个数字，且背包容量为j的情况下，最多能放入多少东西
                int dp[][] = new int[n][sum + 1];
                // dp[0][0] 为初始状态，表示，没有任何没有东西没有体积，其余部分初始化
                for (int i = nums[0]; i <= sum; i++) {
                    dp[0][i] = nums[0];
                }
                // 遍历n个数字，即视为n个产品
                for (int i = 1; i < n; i++) {
                    // 加入了这种物品后更新状态
                    for (int j = nums[i]; j <= sum; j++) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                    }
                }
                // 放满了才能表示正好1/2

                return sum;
            }

        }


}
