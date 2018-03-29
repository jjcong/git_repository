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
        int[] arr = {1,2,3,4,5};
        duplicate(arr);
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
}
