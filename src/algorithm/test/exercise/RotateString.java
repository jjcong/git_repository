package algorithm.test.exercise;

/**
 * *问题描述：
 *  给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串
 *  的尾部，使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间
 *  复杂度为 O(1)。
 *
 * @author  j_cong
 * @date    2018/02/28
 * @version V1.0
 */
public class RotateString {

    public static void main(String[] args) {

        char[] test = {'a','b','c','d','e','f'};

        char[] result = leftRotateString(test, 2);

        System.out.println(result);
    }

    private  static char[] leftRotateString(char[] str, int n) {

        char[] rotateLeft = rotate(str, 0, n - 1);
        char[] rotateRight = rotate(rotateLeft, n, str.length - 1);
        char[] result = rotate(rotateRight, 0, str.length - 1);

        return result;
    }

    /**
     *
     * @param str    输入字符串
     * @param start  起始索引（包含）
     * @param end    结束索引（包含）
     * @return       翻转后的字符串
     */
    private static char[] rotate(char[] str, int start, int end) {

        while (start < end) {

            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;

            start++;
            end--;
        }
        return str;
    }
}
