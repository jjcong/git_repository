package algorithm.test.exercise.stack;

import java.util.Stack;

/**
 * 判断第二个数组是否栈的序列
 * 
 * @author  j_cong
 * @date    2018/04/10
 * @version V1.0
 */
public class IsPopOrderTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] brr = {4, 3, 5, 1, 2};

        System.out.println(isPopOrder(arr, brr));

    }

    public static boolean isPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;

        while (i < pushA.length) {
            stack.push(pushA[i++]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}
