package algorithm.test.exercise.string;
/**
 * 比较两个字符串的内容,只比较一次
 *  如果 A=ABCDEFG B=ACC，则返回false
 * 
 * @author  j_cong
 * @date    2018/03/26
 * @version V1.0
 */
public class CompareStrings {
    public static void main(String[] args) {
        String A = "ABCDEFG";
        String B = "ACC";
        compareStrings(A, B);
    }



    public static boolean compareStrings(String A, String B) {
        // write your code here
        int aLen = A.length();
        int bLen = B.length();
        int[] arr = new int[aLen];

        if (aLen < bLen) {
            return false;
        }

        boolean flag = true;

        for (int i = 0; i < bLen; i++) {
            flag = false;
            for (int j = 0; j < aLen  && !flag; j++) {
                if (B.charAt(i) == A.charAt(j)) {
                    flag = true;
                    arr[j] = 1;
                    break;
                }
            }

            if (!flag) {
                break;
            }
        }

        return flag;
    }
}
