package algorithm.test.exercise;
/**
 * 算法1.1.14
 * 设计一个方法，输入一个整数N，返回不大于logM的最大整数，不能使用Math库
 *
 * @author  j_cong
 * @date    2018/03/06
 * @version V1.0
 */
public class MaxInteger {

    private static int lg(int n) {

        int shiftRightCount = 0;

        while (n != 0) {
            //返回n / 2 d的商
            n >>= 1;
            shiftRightCount++;
        }
        return shiftRightCount - 1;
    }

    public static void main(String[] args) {

        int value = 52;
        int result = lg(value);

        System.out.println(result);
    }
}
