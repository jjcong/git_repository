package algorithm.test.exercise.stack;

import java.util.Stack;

/**
 * 两个栈实现对列
 * 
 * @author  j_cong
 * @date    2018/03/31
 * @version V1.0
 */
public class QueueByStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueByStack() {
        // do intialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    /*
     * @return: An integer
     * 删除并返回栈顶元素
     */
    public int pop() {
        // write your code here
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }

            return stack1.pop();
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }
}
