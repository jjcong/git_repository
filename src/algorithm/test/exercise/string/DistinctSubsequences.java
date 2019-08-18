package algorithm.test.exercise.string;

/**
 * 两个字符串不同的子串个数
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/06/17
 */
public class DistinctSubsequences {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/ed2923e49d3d495f8321aa46ade9f873
     *   思路：dp题。
     *   状态定义：dp[i][j]代表s[0~i-1]中T[0~j-1]不同子串的个数。
     *   递推关系式：S[i-1]!= T[j-1]：  DP[i][j] = DP[i][j-1] （不选择S中的s[i-1]字符）
     *               S[i-1]==T[j-1]： DP[i][j] = DP[i-1][j-1]（选择S中的s[i-1]字符） + DP[i][j-1]
     *   初始状态：第0列：DP[i][0] = 1，第0行：DP[0][j] = 0
     *
     * @param source
     * @param other
     * @return
     */
    public static int numDistinct(String source, String other) {
        if (source == null || other == null || source.length() == 0 || source.length() < other.length()) {
            return 0;
        }
        int sLen = source.length();
        int oLen = other.length();

        int[][] dp = new int[sLen + 1][oLen + 1];

        for (int k = 0; k < sLen; k++) {
            dp[k][0] = 1;
        }

        for (int i = 1; i < sLen; i++) {
            for (int j = oLen; j > 0; j--) {
                if (source.charAt(i) == other.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sLen][oLen];
    }


    /**
     * 因为当前结果只取决于上一行结果的当前位置和后面一位，因此可以降维
     *
     * @param source
     * @param other
     * @return
     */
    public static int numDistinct1(String source, String other) {
        if (source == null || other == null || source.length() == 0 || source.length() < other.length()) {
            return 0;
        }
        int sLen = source.length();
        int oLen = other.length();

        int[]dp = new int[oLen + 1];
        dp[0] = 1;


        for (int i = 1; i < sLen; i++) {
            for (int j = oLen; j > 0; j--) {
                if (source.charAt(i) == other.charAt(j)) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[oLen];
    }
}
