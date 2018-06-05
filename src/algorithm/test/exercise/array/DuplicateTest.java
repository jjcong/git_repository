package algorithm.test.exercise.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找出数组中重复的数字
 *
 * @author  j_cong
 * @date    2018/03/28
 * @version V1.0
 */
public class DuplicateTest {

    public static void main(String[] args) {

//        int[] arr = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6};
        int[] arr = {1,1,1,2};
        duplicate(arr);
        removeDuplicates(arr);
    }

    private static List duplicate(int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i])+ 1);
            }
        }

        for (Integer  tmp : map.keySet()) {
            if (map.get(tmp) != 1) {

                result.add(tmp);
            }
        }

        return result;
    }


    public static int removeDuplicates(int[] A) {

        if (A == null || A.length < 3) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        for (Integer key: map.keySet()) {
            int cnt = map.get(key);
            if (cnt == 1) {
                list.add(key);
            } else {
                list.add(key);
                list.add(key);
            }
        }
        A = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            A[k] = list.get(k);
        }
        return list.size();
    }

    public static int removeDuplicates1(int[] A) {

        if (A == null || A.length < 3) {
            return A.length;
        }

        int index = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] != A[index - 2]) {
                A[index++] = A[i];
            }
        }
        return index;
    }
}
