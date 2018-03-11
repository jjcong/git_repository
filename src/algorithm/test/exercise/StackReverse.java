package algorithm.test.exercise;

import java.lang.reflect.WildcardType;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 利用栈的特性实现倒叙输出
 *
 * @author  j_cong
 * @date    2018/03/07
 * @version V1.0
 */
public class StackReverse {

    public static void main(String[] args) {


        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

         for (int ele : stack) {
             System.out.print(ele);
         }

         for (int i = 0; i < 10; i++) {
             System.out.println(stack.pop());
         }

    }
}
