package algorithm.test.exercise;

/**
 * 数组记录面值，每种货币可用多次，给出总钱数，求换钱的总数
 *
 * @author  j_cong
 * @date    2018/04/12
 * @version V1.0
 */
public class ChangeMoney {

    public static void main(String[] args) {
        ChangeMoney cm = new ChangeMoney();
        int[] arr = {1, 2, 4};
        int result = cm.changeMoney2(arr, 4);
        System.out.println(result);

    }


    /**
     * 暴力破解法，时间复杂度最差为O(aim^N)
     * @param arr
     * @param aim
     * @return
     */
    public int changeMoney1(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);

    }

    public int process(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }


    /**
     * 动态规划，时间复杂度最差为O(aim*N)
     * @param arr
     * @param aim
     * @return
     */
    public int changeMoney2(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int[][] dp = new int[arr.length][aim + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; arr[0] * j < aim + 1; j++) {
            dp[0][arr[0] * j] = 1;
        }

        for (int k = 1; k < arr.length; k++) {
            for (int s = 1; s < aim + 1; s++) {
                dp[k][s] = dp[k - 1][s];
                dp[k][s] += s - arr[k] >= 0 ? dp[k][s - arr[k]] : 0;
            }
        }

        return dp[arr.length - 1][aim];

    }

}
