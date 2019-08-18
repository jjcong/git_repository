package algorithm.test.exercise.string;


/**
 * 验证char[]数组是否为某个整数
 *
 * @author  j_cong
 * @date    2018/05/05
 * @version V1.0
 */
public class IsNumericTest {

    public static void main(String[] args) {
        String str = "-1e-16";
        System.out.println(isNumberic2(str));
    }

    public static boolean isNumberic(char[] str) {

        if (str == null || str.length == 0) {
            return false;
        }

        if (str[str.length - 1] == 'e' || str[str.length - 1] == 'E') {
            return false;
        }

        //小数点的个数
        int pointFlag = 0;
        //科学计数法标记
        boolean eFlag = false;
        int start = 0;

        if (str[0] == '-' || str[0] == '+') {
            start++;
        }

        if (start >= str.length) {
            return false;
        }

        int i = start;

        while (i < str.length) {
            //如果索引处为E或e，必须保证E（e)前面不能为非数字，后面只能为+、-、或者数字
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == start) {
                    return false;
                } else {
                   return isInteger(str, i + 1);
                }
                //如果索引处为小数点，必须保证小数点只能有一个
            } else if (str[i] == '.') {
                if (pointFlag > 0) {
                    return false;
                } else {
                    pointFlag++;
                }

            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }

            i++;
        }

        return true;
    }


    public static boolean isInteger(char[] str, int start) {

        if (str == null || start >= str.length) {
            return false;
        }
        if (str[start] == '+' || str[start] == '-') {
            start++;
        }
        if (start >= str.length) {
            return false;
        }

        int i = start;

        while (i < str.length) {
            if (str[i] < '0' || str[i] > '9') {
                return  false;
            }
            i++;

        }
        return true;
    }


    public static boolean isNumberic1(char[] str) {
        try {
            char c = str[str.length - 1];
            if(c == 'f' || c == 'F' || c == 'd' || c == 'D') {
                return false;
            }
            Double num = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    /**
     *
     *
     * 发现解答很多都用了一些小技巧，比如正则，或者NumberFormatException
     * 实际上这些解法都调用库函数，个人觉得不是出题者的真正意图
     *
     *
     * Runtime: 3 ms.Your runtime beats 83.72 % of java submissions.
     * 思路：这道题关键是分析所有会出现的情况。以及设置关键的flag来记录各种情况
     * 首先使用trim()函数去除前后空格。
     * 设置4个标志，分别是
     * boolean pointSeen = false;//是否出现过小数点“.”
     * boolean eSeen =alse;//是否出现过指数标志“e”
     * boolean numberSeen = false;//是否出现过数字
     * booleannumberAfterE = true;//e后面是否有数字
     * 进行循环s.charAt(i)：
     * 1.如果属于[0,9]，把numberSeen设为true
     * 2.如果是‘.’，必须之前没有遇到'.'和'e'
     * 3.如果是'e'，必须之前没有遇到过'e'
     * 4.如果是'+'或者'-',当前i必须是0，或者i-1上的字符是e
     * 5.其他情况返回false
     *
     *
     * @param str
     * @return
     */
    public static boolean isNumberic2(String str) {

        str = str.trim();
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean numSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numAfterE = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                numSeen = true;
                numAfterE = true;
            } else if (c == '.') {
                if (pointSeen || eSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e' || c == 'E') {
               if (eSeen || !numSeen) {
                   return false;
               }
               eSeen = true;
               numAfterE = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && (str.charAt(i - 1) != 'e')) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return  numSeen && numAfterE;
    }

    public static int strToInt(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return  0;
        }
        int pos = 0;
        int isNegtive = 1;
        if (str.charAt(pos) == '+') {
            pos++;
        }
        if (str.charAt(pos) == '-') {
            isNegtive = -1;
            pos++;
        }
        int res = 0;

        for (int i = pos; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10
                && c > '7')) {
                return isNegtive == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + c - '0';
        }

        return  res * isNegtive;
    }
}
