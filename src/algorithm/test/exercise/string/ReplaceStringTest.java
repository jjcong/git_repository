package algorithm.test.exercise.string;
/**
 * 判断两个字符串是否可以置换
 *
 * @author  j_cong
 * @date    2018/03/30
 * @version V1.0
 */
public class ReplaceStringTest {


    public static void main(String[] args) {

        String str1 = "abcd";
        String str2 = "bcad";

        System.out.println( replaceString1(str1, str2));

    }

    /**
     * 判断两个字符串是否可以置换.方法有问题。只通过86%
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean replaceString1(String A, String B) {
        // write your code here
        int aLen = A.length();
        int bLen = B.length();

        if (aLen != bLen) {
            return false;
        }

        int[] arr = new int[aLen];

        for (int i = 0; i < aLen ; i++) {
            //每找到一个匹配值的标志，如果没有找到直接返回false
            boolean flag = false;

            for (int j = 0; j < bLen ; j++) {
                //arr[j] == 0此条件用于忽略重复值
                if (A.charAt(i) == B.charAt(j) && arr[j] == 0) {
                    arr[j] = 1;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                return false;
            }
        }

        return true;

    }

    /**
     * 判断两个字符串是否可以置换.方法有问题。也只通过86%
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean replaceString2(String A, String B) {
        // write your code here
        int aLen = A.length();
        int bLen = B.length();

        if (aLen == 0 && bLen == 0) {
            return true;
        }

        if (aLen != bLen) {
            return false;
        }

        int[] arr = new int[128];

        for (int i = 0; i < aLen ; i++) {
            arr[(int)A.charAt(i)] += 1;
        }
        for (int j = 0; j < aLen ; j++) {
            arr[(int)B.charAt(j)] -= 1;
        }
        for (int k = 0; k < arr.length ; k++) {
            if (arr[k] != 0) {
                return false;
            }
        }

        return true;

    }


}
