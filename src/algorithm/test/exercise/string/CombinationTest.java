package algorithm.test.exercise.string;
/**
 * 字符串的所有组合
 *
 * @author  j_cong
 * @date    2018/03/30
 * @version V1.0
 */
public class CombinationTest {

    public static void main(String[] args) {
        String str = "abcajfdfjlajdfljsdlkfajlkjdgflkjsadlfjlsajggfasdfasg";
//        combination1(str.toCharArray());
        combine("abc");
    }

    /**
     * 字符串的所有组合,一位代表一个元素（字符），使用移位运算
     * 只能处理不超过32位的字符串
     *
     * @param source
     */
    private static void combination1(char[] source) {
        int n = source.length;

        int nBit = 1 << n;

        for (int i = 0; i < nBit; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 1 << j;
                // 与运算，同为1时才会是1
                if ((tmp & i) != 0) {
                    System.out.print(source[j]);
                }
            }
            System.out.println();
        }

        System.out.println("结果数为:" + (nBit - 1));
    }


    public static void combine(String str) {
        //如果字符串为空，则直接返回
        if (str == null)
            return;
        //创建字符串容器
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            combination(str, 0, i, sb);
        }
    }

    /**
     * 字符串的所有组合
     *
     * @param str
     * @param index   控制输出字符的个数
     * @param number  控制输出
     * @param sb      用于输出字符
     */
    public static void combination(String str, int index, int number, StringBuilder sb) {

        if (number == -1) {
            System.out.println(sb.toString());
            return;
        }
        if (index == str.length())
            return;
        //向StringBuilder中添加元素
        sb.append(str.charAt(index));
        combination(str, index + 1, number - 1, sb);
        //在StringBuilder中删除元素
        sb.deleteCharAt(sb.length() - 1);
        combination(str, index + 1, number, sb);
    }
}
