package algorithm.test.exercise.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 两个字符串相加
 *
 * @author  j_cong
 * @date    2018/05/20
 * @version V1.0
 */
public class StringAddTest {
    public static void main(String[] args) {
        StringAddTest test = new StringAddTest();
        String a = "136";
        String b = "987";

        System.out.println(test.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int carry = 0;

        while (aLen >= 0 || bLen >= 0 || carry != 0) {
            int curSum = carry;
            if (aLen >= 0) {
                curSum += a.charAt(aLen--) - '0';
            }
            if (bLen >= 0) {
                curSum += b.charAt(bLen--) - '0';
            }
            sb.append(curSum % 10);
            carry = curSum / 10;
        }
        return sb.reverse().toString();
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            int curStart = intervals.get(i).start;
            int curEnd = intervals.get(i).end;
            int lastStart = intervals.get(res.size() - 1).start;
            int lastEnd = intervals.get(res.size() - 1).end;
            if (lastEnd >= curStart) {
                res.get(res.size() - 1).end = Math.max(curEnd, lastEnd);
            } else {
                res.add(intervals.get(i));
            }
        }

        return res;
    }
}
