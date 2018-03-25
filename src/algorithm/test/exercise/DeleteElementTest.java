package algorithm.test.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * 删除数组指定元素
 *
 * @author  j_cong
 * @date    2018/03/24
 * @version V1.0
 */
public class DeleteElementTest {

    public static int removeElement(int[] A, int elem) {
        // write your code here
        int length = A.length;
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            if (A[i] != elem) {
                list.add(A[i]);
            }
        }

        return list.size();
    }

    public static void main(String[] args) {
        int[] arr = {0, 4, 4, 0, 4, 4, 4, 0, 2};
        removeElement(arr, 4);

    }

}
