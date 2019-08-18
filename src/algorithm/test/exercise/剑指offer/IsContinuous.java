package algorithm.test.exercise.剑指offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * 判断抽出来的五张牌是否为顺子  运满满面试
 * 思路：1）计算数组中大小王个数
 *       2）排序
 *       3）判断数组最大间隔数是否<大小王个数
 *
 * @author  j_cong
 * @date    2018/09/22
 * @version V1.0
 */
public class IsContinuous {

    public static void main(String[] args) {
        int[] arr = {0,0,3,5,8};
        System.out.println(isContinuous(arr));
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        stack.push(2);
        stack.push(null);
        stack.push(null);

        stack.stream().forEach(e -> System.out.println(e));
    }


    public static boolean isContinuous(int[] arr) {
        Arrays.sort(arr);
        int numOfZero = 0;
        for (int num : arr) {
            if (num == 0) {
                numOfZero++;
            }
        }
        for (int i = numOfZero; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
            numOfZero -= arr[i + 1] - arr[i] - 1;
            if (numOfZero < 0) {
                return false;
            }
        }

        return true;

    }

}
