package algorithm.test.exercise.笔试真题.京东;
/**
 * 删减字符串的部分字符，使之成为回文数
 * 
 * @author  j_cong
 * @date    2018/04/11
 * @version V1.0
 */
public class PlalindromeTest {

    public static void main(String[] args) {
        String str = "ABA";
        int result = count(str);

        System.out.println(result);
    }

    public static int count(String str) {
        int length = str.length();
        int[][] cps = new int[length + 1][length + 1];

        for (int i = 0; i < length; i++) {
            cps[i][i] = 1;
        }

        for (int k = 2; k <= length; k++) {
            for (int s = 0; s < length; s++) {
                int t = k + s - 1;
                if (t < length) {
                    if (str.charAt(s) == str.charAt(t)) {
                        cps[s][t] = cps[s][t - 1] + cps[s + 1][t] + 1;
                    } else {
                        cps[s][t] = cps[s][t - 1] + cps[s + 1][t] - cps[s + 1][t - 1];
                    }
                }
            }
        }
        return cps[0][length - 1];
    }
}
