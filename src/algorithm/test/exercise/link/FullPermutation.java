package algorithm.test.exercise.link;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符去重后进行全排列
 *
 * @author  j_cong
 * @date    2018/03/17
 * @version V1.0
 */
public class FullPermutation {

    public static void main(String[] args) {

        String str = "CCTV";
        String result = "";
        char[] cs = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : cs) {
            if (!map.containsKey(c)) {
                result += c;
                map.put(c, 1);
            }
        }
        System.out.println(result);


        fastPermutation(result.toCharArray(), 0);
    }


    /**
     * 从字符串数组中每次选取一个元素，作为结果中的第一个元素;然后，对剩余的元素全排列
     *
     * @param chars
     * @param cursor
     */
    private static void fastPermutation(char[] chars, int cursor) {

        int length = chars.length;

        //递归边界，到达最后一个
        if (cursor == length - 1) {
            for (int i = 0; i < length; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
        } else {
            //循环实现交换和之后的全排列
            for (int i = cursor; i < length ; i++) {
                //交换前缀,作为结果中的第一个元素，然后对剩余的元素全排列
                swap(chars, i, cursor);
                // 递归调用，缩小问题的规模
                fastPermutation(chars, cursor + 1);
                //递归之后再交换过来，保证固定前一个数的全排列,换回前缀，复原字符数组
                swap(chars, i , cursor);
            }
        }

    }

    private static void swap(char[] ps, int pa, int pb) {
        char tmp = ps[pa];
        ps[pa] = ps[pb];
        ps[pb] = tmp;

    }
}
