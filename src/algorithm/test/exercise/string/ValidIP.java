package algorithm.test.exercise.string;

import network.test.tcp.ip.ServerOutputThread;

import java.util.ArrayList;

/**
 * 给定字符串，计算能够组成的有效IP数
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/09/07
 */
public class ValidIP {
    public static void main(String[] args) {
        String str = "25525511135";
        ArrayList<String> res = restoreIpAddresses(str);

        res.stream().forEach(e -> System.out.println(e));
    }

    public static ArrayList<String> restoreIpAddresses(String s) {

        ArrayList<String> rst = new ArrayList<String>();

        for (int i = 0; i < 4 && i < s.length(); i++) {
            for (int j = i + 1; j < i + 5 && j < s.length(); j++) {
                for (int k = j + 1; k < j + 5 && k < s.length(); k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if (isValide(s1) && isValide(s2) && isValide(s3) && isValide(s4)) {
                        rst.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }

        return rst;
    }

    private static boolean isValide(String s) {
        if (s.length() == 0) return false;
        if (s.length() == 1) return true;
        if (s.length() == 2) return s.charAt(0) != '0';
        if (s.length() == 3) {
            int tmp = Integer.parseInt(s);
            return tmp >= 100 && tmp <= 255;
        }
        return false;
    }
}
