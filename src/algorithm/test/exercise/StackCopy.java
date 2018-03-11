package algorithm.test.exercise;

import java.util.Stack;

/**
 * 复制Stack
 * 
 * @author  j_cong
 * @date    2018/03/08
 * @version V1.0
 */
public class StackCopy {

    public static <T> Stack<T> copy(Stack<T> originalStack) {

        Stack<T> stack = new Stack<>();

        for (T str : originalStack) {
            stack.push(str);
        }

        return stack;
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        Stack<Integer> result = copy(stack);

        for (Integer str : result) {
            System.out.println(str);
        }
    }
}
