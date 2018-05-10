package algorithm.test.exercise.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 字符串中第一次出现的字符
 * 思路：时间复杂度O（1），空间复杂度O（n）
 *    1、用一个128大小的数组统计每个字符出现的次数
 *    2、用一个队列，如果第一次遇到ch字符，则插入队列；其他情况不在插入
 *    3、求解第一个出现的字符，判断队首元素是否只出现一次，如果是直接返回，否则删除继续第3步骤
 *
 * @author  j_cong
 * @date    2018/05/02
 * @version V1.0
 */
public class FirstAppearingOnce {

    Queue<Character> queue = new LinkedList<>();
    int[] cnt = new int[128];

    public void insert(char c) {
        ++cnt[c - '0'];
        if (cnt[c - '0'] == 1) {
            queue.offer(c);
        }
    }

    public char firstAppearingOnce() {

        while (!queue.isEmpty() && cnt[queue.peek() - '0'] > 1) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            return '#';
        }
        return queue.peek();
    }

       /*
    int[] hash = new int[128];
    StringBuilder sb = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        hash[ch] = hash[ch] == 0 ? 1 : hash[ch] + 1;

    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] word = sb.toString().toCharArray();
        for (char tmp : word) {
            if (1 == hash[tmp]) {
                return tmp;
            }
        }
        return '#';
    }
    */

}
