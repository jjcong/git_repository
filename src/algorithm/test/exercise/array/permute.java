package algorithm.test.exercise.array;

import java.util.ArrayList;
/**
 * 数组的全排列
 *
 * @author  j_cong
 * @date    2018/04/08
 * @version V1.0
 */
public class permute {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> permute(int[] num) {
            if (num == null || num.length == 0) {
                return null;
            }
            permute(num, 0, num.length - 1);

            return result;
        }

        public void permute(int[] num, int start, int end) {

            if (start == end) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < num.length; i++) {
                    tmp.add(num[i]);
                }
                result.add(tmp);
            } else {
                for (int j = start; j <= end; j++) {
                    swap(num, j, start);
                    permute(num, start + 1, end);
                    swap(num, j, start);
                }
            }

        }

        public void swap(int[] arr, int start, int end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }
