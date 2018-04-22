package algorithm.test.exercise.array;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 * 
 * @author  j_cong
 * @date    2018/04/16
 * @version V1.0
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        FindContinuousSequence find = new FindContinuousSequence();
        find.findContinuousSequence(9);
    }

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) {
            return res;
        }
        int small = 1;
        int big = 2;
        int mid = (sum + 1) / 2;
        int curSum = small + big;

        while (small < mid) {
            if (curSum == sum) {
                res.add(printResult(small, big));
            }
            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    res.add(printResult(small, big));
                }
            }
            big++;
            curSum += big;
        }
        return res;
    }

    public ArrayList<Integer> printResult(int small, int big) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            list.add(i);
        }
        return list;
    }

}
