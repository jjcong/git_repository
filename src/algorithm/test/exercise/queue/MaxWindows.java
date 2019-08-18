package algorithm.test.exercise.queue;
/**
 * 活动窗口的最大值
 *
 * @author j_cong
 * @date 2018/04/25
 * @version V1.0
 */

import algorithm.test.exercise.tree.TreeNode;

import java.util.*;

public class MaxWindows {

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};

        ArrayList list = maxInWindows(arr, 3);


    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> res = new ArrayList<>();

        if (num == null || size < 1 || size > num.length) {
            return null;
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);

            //当前对头下标已过期，弹出
            if (deque.peekFirst() == i - size) {
                deque.pollFirst();
            }

            if (i >= size - 1) {
                res.add(num[deque.peekFirst()]);
            }
        }

        return res;
    }

    public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (size > num.length || size < 1) {
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            maxHeap.add(num[i]);
        }
        res.add(maxHeap.peek());
        for (int i = 1; i + size - 1 < num.length; i++) {
            maxHeap.remove(num[i - 1]);
            maxHeap.add(num[i + size - 1]);
            res.add(maxHeap.peek());
        }
        return res;
    }

}
