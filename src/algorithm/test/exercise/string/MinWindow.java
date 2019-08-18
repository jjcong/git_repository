package algorithm.test.exercise.string;
/**
 * 给定两个字符串S,T，求S中包含T的最小窗口
 * https://www.nowcoder.com/questionTerminal/c466d480d20c4c7c9d322d12ca7955ac
 *
 * @author  j_cong
 * @date    2018/10/05
 * @version V1.0
 */
public class MinWindow {

    public String minWindow(String src, String target) {
        int[] hash = new int[128];
        //init hash, 记录T中每个元素出现的次数
        for (int i = 0; i < target.length(); i++) {
            hash[target.charAt(i)]++;
        }
        // begin end两个指针指向窗口的首位，width记录窗口的长度， left记录T中还有几个字符没被窗口包含
        int begin = 0;
        int end = 0;
        int width = Integer.MAX_VALUE;
        int left = target.length();
        int head = 0;

        while (end < src.length()) {
            // hash[] > 0 说明该字符在T中出现，left-- 表示对应的字符被包含在了窗口，left--,
            // 如果s中的字符没有在T中出现，则map[]中对应的字符-1后变为负值
            if(hash[src.charAt(end++)]-- > 0) {
                left--;
            }
            // 当left==0时，说明窗口已经包含了T中的所有字符
            while (left == 0) {
                if(end - begin < width) {
                    head = begin;
                    width = end - begin;
                }
                // begin开始后移，继续向后寻找。如果begin后移后指向的字符在hash中==0，
                // 表示是在T中出现的，如果没有出现，map[]中的值会是负值

                if(hash[src.charAt(begin++)]++ == 0) {
                    // 在T中的某个字符从窗口中移除，所以counter++。
                    left++;
                }
            }
        }

        return width == Integer.MAX_VALUE ? "" : src.substring(head, head + width);
    }
}
