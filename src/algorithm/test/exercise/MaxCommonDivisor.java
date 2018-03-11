package algorithm.test.exercise;

/**
 * 最大公约数算法
 *     1、[求余数]，令r=m%n，r为n除m所得余数（0<=r<n）；
 *     2、[余数为0?]，若r=0，算法结束，此刻，n即为所求答案，否则，继续，转到3；
 *     3、[重置]，置m<n，n<r，返回步骤1.
 * 
 * @author  j_cong
 * @date    2018/03/01
 * @version V1.0
 */
public class MaxCommonDivisor {

    private static int maxCommonDivisor(int large, int small) {

        int tmp = large % small;

        if (0 != tmp) {
            large = small;
            small = tmp;
            int result = maxCommonDivisor(large, small);

            return result;
        }

        return small;

    }

    public static void main(String[] args) {

        int a = 56;
        int b = 48;

        int result = MaxCommonDivisor.maxCommonDivisor(a, b);
        System.out.println(result);
    }
}
