package algorithm.test.exercise.tree;
/**
 * 判断某一数组是否为某个数的后序遍历
 *
 * @author  j_cong
 * @date    2018/04/10
 * @version V1.0
 */
public class VerifySequenceOfBST {

    public static void main(String[] args) {
        int[] arr = {5, 7, 6, 9, 11, 10, 8};

        VerifySequenceOfBST obj = new VerifySequenceOfBST();
        boolean result = obj.VerifySquenceOfBST(arr);
        System.out.println(result);
    }

    public boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence == null || sequence.length == 0) {
            return false;
        }

        boolean result = getRes(sequence, 0, sequence.length - 1);

        return result;

    }

    public boolean getRes(int[] arr, int start, int end) {


        if (end - start <= 1) {
            return true;
        }

        int i = 0;

        while (i < end) {
            if (arr[i] > arr[end]) {
                break;
            }
            i++;
        }

        int j = i;
        while (j < end) {
            if (arr[j] < arr[end]) {
                return false;
            }
            j++;
        }

        boolean leftFlag = true;
        boolean rightFlag = true;

        if (i > 0) {
            leftFlag = getRes(arr, start, i - 1);
        }

        if (i < arr.length - 1) {
            rightFlag = getRes(arr, i, end - 1);
        }

        return leftFlag && rightFlag;

    }
}
