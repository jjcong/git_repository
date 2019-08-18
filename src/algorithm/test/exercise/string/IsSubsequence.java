package algorithm.test.exercise.string;
/**
 * 判断s是否为t的子串
 * s = "abc", t = "ahbgdc"    true
 * s = "axc", t = "ahbgdc"    false
 * 
 * @author  j_cong
 * @date    2018/09/06
 * @version V1.0
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
