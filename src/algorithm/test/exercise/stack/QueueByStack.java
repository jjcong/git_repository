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
    Stack<Integer> pushStack = new Stack<Integer>();
    Stack<Integer> popStack = new Stack<Integer>();

    public void push(int node) {
        pushStack.push(node);
    }

    public int pop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

        return popStack.pop();
    }
}
