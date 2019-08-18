package algorithm.test.exercise.笔试真题.美团;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_apple {

    public static void main(String[] args) throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        String[] aStrings = new String[4];
        for (int i = 0; i <= 3; i++) {
            aStrings[i] = scanner.nextLine();
        }
        int duishu = Integer.valueOf(aStrings[0]);
        Map<String, Integer> map = new HashMap<>();
        String[] duilidegeshu = aStrings[1].split(" ");
        long question = Long.valueOf(aStrings[2]);
        String[] xunwen = aStrings[3].split(" ");
        int[] a = new int[(int) duishu];
        a[0] = Integer.valueOf(duilidegeshu[0]);
        for (int j = 1; j < duishu; j++) {
            a[j] = a[j - 1] + Integer.valueOf(duilidegeshu[j]);
        }
        Output(duishu, duilidegeshu, question, xunwen, map, a);
    }

    private static void Output(int duishu, String[] duilidegeshu, long question, String[] xunwen, Map<String, Integer> map, int[] a) {
        // TODO Auto-generated method stub
        for (int i = 0; i < question; i++) {
            outputinner(duishu, duilidegeshu, xunwen[i], map, a);
        }
    }

    private static void outputinner(int duishu, String[] duilidegeshu, String string, Map<String, Integer> map, int[] a) {
        // TODO Auto-generated method stub
        int sum = 0;
        if (map.containsKey(string)) {
            System.out.println(map.get(string));
        } else {
            diguierfen(a, 0, duishu, string, map);
        }
    }

    private static void diguierfen(int[] a, int start, int end, String string, Map<String, Integer> map) {
        // TODO Auto-generated method stub
        int zhongjian = a[(int) (start + (end - start) / 2)];
        if (Integer.valueOf(string) < zhongjian) {
            end = start + (end - start) / 2;
            if (end - start <= 1) {
                if (Integer.valueOf(string) < a[start]) {
                    System.out.println(end);
                    map.put(string, end);
                } else {
                    System.out.println(end + 1);
                    map.put(string, end + 1);
                }

            } else {
                diguierfen(a, start, end, string, map);
            }
        } else if (Integer.valueOf(string) > zhongjian) {
            start = start + (end - start) / 2;
            if (end - start <= 1) {
                System.out.println(end + 1);
                map.put(string, end + 1);
            } else {
                diguierfen(a, start, end, string, map);
            }
        } else {
            System.out.println(start + (end - start) / 2 + 1);
            map.put(string, end + 1);
        }
    }
}

