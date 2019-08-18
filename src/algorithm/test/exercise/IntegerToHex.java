package algorithm.test.exercise;
/**
 * 十进制数转为16进制
 *
 * @author  j_cong
 * @date    2018/08/26
 * @version V1.0
 */
public class IntegerToHex {
    public static void main(String[] args) {
        System.out.println(toHex(89));
        System.out.println(inverseInteger(-12345));
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String res = "";
        while (num != 0) {
            //获得除以16后的余数相当于num%16
            int cur = num & 0xF;
            res = map[cur] + res;
            num >>>= 4;
        }
        return res;
    }

    public static int inverseInteger(int num) {
        int cur = num > 0 ? num : -num;
        int res = 0;
        while (cur != 0) {
            res = res * 10 + cur % 10;
            cur /= 10;
        }
        return num > 0 ? res : -res;

    }
}

