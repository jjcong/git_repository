package algorithm.test.exercise.string;

import java.util.Arrays;

/**
 * 将给定字符串中的空格替换为%23
 *
 * @author  j_cong
 * @date    2018/03/28
 * @version V1.0
 */
public class ReplaceBlankTest {

    public static void main(String[] args) {

        String str = "We are happy!";

        System.out.println(replaceBlank1(str));

    }


    /**
     * 方法一，先统计空格数目，然后新建一个char数组，全部复制
     * 如果在原地复制效率会更高
     *
     * @param str
     * @return
     */
    public static String replaceBlank1(String str) {

        if (str == null || str.length() == 0) {
            return str;
        }

        char[] oldStr = str.toCharArray();
        int length = str.length();
        int blankNum = 0;

        for (int i = length - 1; i >= 0; i--) {
            if (' ' == oldStr[i]) {
                blankNum++;
            }
        }

        //获得替换后的数组长度
        int newLength = length + blankNum * 2;

        char[] newChar = Arrays.copyOf(oldStr, newLength);

//        char[] newChar = new char[newLength];

        int oldIndex = length - 1;
        int newIndex = newLength - 1;

        while (oldIndex >= 0 && newIndex > oldIndex) {

            if (oldStr[oldIndex] != ' ') {
                newChar[newIndex--] = oldStr[oldIndex];
            } else {
                newChar[newIndex--] = '0';
                newChar[newIndex--] = '2';
                newChar[newIndex--] = '%';
            }

            oldIndex--;
        }


        return String.valueOf(newChar);
    }

    /**
     * 方法一，先统计空格数目，然后新建一个char数组，全部复制
     *
     * @param str
     * @return
     */
    public static String replaceBlank2(String str) {

        if (str == null || str.length() == 0) {
            return str;
        }

        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String tmp : strs) {
            sb.append(tmp).append("%20");
        }

        String result = sb.toString();

        //将最后的"%20"去掉
        return result.substring(0, result.length() - 3);
    }
}
