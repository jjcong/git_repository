package algorithm.test.exercise.string;
/**
 * 给定字符串，求切分成回文数的最少次数
 * 
 * @author  j_cong
 * @date    2018/09/07
 * @version V1.0
 */
public class MinCutPalindrome {

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

    public boolean isPalindrome(String src, int i, int j) {
        while (i < j) {
            if (src.charAt(i) != src.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
