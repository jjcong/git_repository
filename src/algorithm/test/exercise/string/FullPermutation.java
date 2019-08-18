package algorithm.test.exercise.string;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 数组的全排列
 *
 * @author  j_cong
 * @date    2018/09/07
 * @version V1.0
 */
public class FullPermutation {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        FullPermutation test = new FullPermutation();
        test.permuteUnique(arr);

    }



    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
            return res;
        }
        pemutation(num, 0);
        return res;

    }
    public void pemutation(int[] arr, int start) {
        if (start == arr.length - 1) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int num : arr) {
                cur.add(num);
            }

            res.add(cur);
        } else {
            for (int i = start; i < arr.length; i++) {
                if (i != start && arr[i] == arr[start]) {
                    continue;
                }
                swap(arr, i, start);
                pemutation(arr, start + 1);
                swap(arr, i, start);
            }
        }


    }
    public void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }
}
