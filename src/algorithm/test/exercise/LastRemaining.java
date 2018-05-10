package algorithm.test.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 每次删除第m个数，返回最后剩下的数
 *
 * @author  j_cong
 * @date    2018/04/25
 * @version V1.0
 */
public class LastRemaining {

    public static void main(String[] args) {
        LastRemaining lr = new LastRemaining();
        lr.LastRemaining_Solution(5, 3);
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = -1;

        while (list.size() > 1) {
            index = (index + m) % list.size();
            list.remove(index);
            index--;
        }

        return list.get(0);
    }

}
