package algorithm.test.demo;

import java.util.*;

    public class test {

        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);

            int count = Integer.valueOf(in.nextLine());
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();

            for (int i = 0; i < count; i++) {
                String s = in.nextLine();
                String[] strings = s.split(" ");
                if ("1".equals(strings[0])) {
                    int start = Integer.parseInt(strings[1]);
                    int end = Integer.parseInt(strings[2]);
                    int money = Integer.parseInt(strings[3]);
                    for (int j = start; j <= end; j++) {
                        if (map1.get(j) == null) {
                            map1.put(j, money);
                        } else {
                            map1.put(j, Math.max(map1.get(j), money));
                        }
                    }
                } else if ("2".equals(strings[0])) {
                    int date = Integer.parseInt(strings[1]);
                    int money = Integer.parseInt(strings[2]);
                    if (map2.get(date) == null) {
                        map2.put(date, money);
                    } else {
                        map2.put(date, Math.max(map2.get(date), money));
                    }
                }
            }
            Set<Integer> set = map1.keySet();
            int res = 0;
            for (Integer s : set) {
                res += map1.get(s);
            }
            set = map2.keySet();
            for (Integer s : set) {
                res += map2.get(s);
            }
            System.out.println(res);
        }

    }
