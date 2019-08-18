package algorithm.test.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值，剑指offer P288
 *
 * @author  j_cong
 * @date    2018/09/05
 * @version V1.0
 */
public class MaxInWindow {

    public static void main(String[] args) {
        int[] arr = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(arr, 3));
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size)
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
