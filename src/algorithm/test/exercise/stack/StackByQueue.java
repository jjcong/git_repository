package algorithm.test.exercise.stack;
/**
 * 使用两个队列实现栈
 * 
 * @author  j_cong
 * @date    2018/09/05
 * @version V1.0
 */
import java.util.LinkedList;
import java.util.Queue;

public class StackByQueue {
    private Queue<Integer> pushQueue = new LinkedList<>();
    private Queue<Integer> popQueue = new LinkedList<>();

    public void push(int num) {
        pushQueue.offer(num);
    }
    
    public int pop() {
        if (pushQueue.size() == 1) {
            return pushQueue.peek();
        } else {
            while (pushQueue.size() != 1) {
                popQueue.offer(pushQueue.poll());
            }
            int res = pushQueue.poll();
            
            while (!popQueue.isEmpty()) {
                pushQueue.offer(popQueue.poll());
            }
            return res;
        }
    }
}
