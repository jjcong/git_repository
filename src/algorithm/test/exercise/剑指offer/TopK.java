package algorithm.test.exercise.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {
    public static void main(String[] args) {
        int[] arr = {5,3,7,1,8,2,9,4,7,2,6,6};
        //System.out.println(sort(arr, 5));
        //System.out.println(bubbleSort(arr, 5));
        System.out.println(heapSort(arr, 5));

    }

    /**
     * 直接排序思想   时间复杂度O（n*logn）
     *
     * @param arr
     * @param k
     * @return
     */
    public static List<Integer> sort(int[] arr, int k) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * 冒泡思想   时间复杂度O（n*k）
     *
     * @param arr
     * @param k
     * @return
     */
    public static List<Integer> bubbleSort(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            list.add(arr[i]);
        }
        return list;
    }

    public static List<Integer> heapSort(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for(int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return new ArrayList<>(maxHeap);
        }

}
