package algorithm.test.exercise.array;


/**
 * 统计key在有序数组中出现的次数
 *
 * @author  j_cong
 * @date    2018/04/15
 * @version V1.0
 */
public class Count {

    public static void main(String[] args) {

        Count obj = new Count();
        int[] arr = {1, 2, 3, 3, 3, 3};
        System.out.println(obj.getNumberOfK(arr, 2));
    }

    /**
     * 思路：二分法，如果中间为key，则遍历左右得到重复的key
     *
     * @param array
     * @param k
     * @return
     */
    public int getNumberOfK(int [] array , int k) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int lower = getLower(array, k);
        int upper = getUpper(array, k);
        int result = upper - lower - 1;

        return result == -1 ? 0 : result;
    }
    public int getLower(int[] arr, int k) {

        int start = 0;
        int end = arr.length - 1;


        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                while (mid >= start && arr[mid] == k) {
                    mid--;
                }
                return mid;

            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int getUpper(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                while (mid <= end && arr[mid] == k) {
                    mid++;
                }
                return mid;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
