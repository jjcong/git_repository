package algorithm.test.exercise.array;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 思想；维护两个堆
 *  如果 总数为偶数，将num经最大堆过滤后存入小顶堆
 *  如果 总数为奇数，将num经最小堆过滤后存在大顶堆
 *
 *  取中位数时，
 *  如果总数为偶数，将大顶堆+小顶堆相加/2
 *  如果为奇数，去最小堆堆顶元素
 * 
 * @author  j_cong
 * @date    2018/09/01
 * @version V1.0
 */
public class GetMidFromArray {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, (o1, o2) -> o2.compareTo(o1));
    int count = 0;

    public void add(int num) {
        int filterNum = 0;
        //当数据总数为偶数时，新加入的元素，应当进入小根堆
        //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
        //当数据总数为奇数时，新加入的元素，应当进入大根堆
        //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
        if (count % 2 == 0) {
            maxHeap.offer(num);
            filterNum = maxHeap.poll();
            minHeap.offer(filterNum);
        } else {
            minHeap.offer(num);
            filterNum = minHeap.poll();
            maxHeap.offer(filterNum);
        }
        count++;
    }

    public Double getMid() {
        Double res = 0D;
        if (count % 2 == 0) {
            return new Double(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }

}
