package algorithm.test.demo;

/**
 * 二分法
 *
 * @author  j_cong
 * @date    2017/10/24
 * @version V1.0
 */
public class BinarySearch {

    private static int rank(int key, int[] a) {

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            //避免溢出
            int mid = lo + (hi - lo) / 2;

            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1 ;
            } else {
                return a[mid];
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] test = {9, 8, 7, 6, 5, 4, 1};

        int key = 6;

        int result = BinarySearch.rank(key, test);
        System.out.println(result);
    }
}
