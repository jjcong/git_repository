package algorithm.test.exercise;

import java.util.HashMap;
import java.util.Map;
/**
 * 找出数组中只出现一次的数（仅有一个）
 *
 * @author  j_cong
 * @date    2018/03/17
 * @version V1.0
 */
public class SingleNumber {

    public static int singleNumber(int[] A) {
        int length = A.length;
        int result = 0;
        if (A == null || length == 0) {
            return 0;
        }
        Map<Integer, Boolean> map = new HashMap<>(length);
        for (int i = 0; i < length; i++){
            if (!map.containsKey(A[i])) {
                map.put(A[i], true);
            } else {
                map.put(A[i], false);
            }
        }

        for (Integer i : map.keySet()){
            if(map.get(i)) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 1};

        int a = singleNumber(arr);
        System.out.println(a);
    }


}
