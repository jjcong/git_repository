package algorithm.test.exercise.笔试真题.去哪儿;

import java.util.*;


public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] peoples = in.nextLine().split(" ");
        int[] ma = new int[peoples.length];
        int pingjun = 0;
        for (int i = 0; i < peoples.length; i++) {
            ma[i] = Integer.parseInt(in.nextLine().split(" ")[1]);
            pingjun += ma[i];
        }
        pingjun = (int) Math.floor((double) pingjun / peoples.length);
        for (int i = 0; i < peoples.length; i++) {
            ma[i] = ma[i] - pingjun;
        }
        ArrayList<ArrayList<Object>> list = new ArrayList<>();
        for (int i = 0; i < peoples.length; i++) {
            ArrayList<Object> list1 = new ArrayList<>();
            list1.add(peoples[i]);
            list1.add(ma[i]);
            list.add(list1);
        }
        Collections.sort(list, new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
                return (Integer) o1.get(1) - (Integer) o2.get(1);
            }
        });
        logic(list, 0, list.size() - 1);


    }

    private static void logic(ArrayList<ArrayList<Object>> list, int fu, int zheng) {
        if ((Integer) list.get(fu).get(1) >= 0 || (Integer) list.get(zheng).get(1) <= 0) {
            return;
        }
        int small = (Integer) list.get(fu).get(1);
        int big = (Integer) list.get(zheng).get(1);
        if (small + big >= 0) {
            System.out.println((String) list.get(fu).get(0) + " " + (String) list.get(zheng).get(0) + " " + (-small));
            list.get(zheng).set(1, big + small);
            fu++;
        } else {
            System.out.println((String) list.get(fu).get(0) + " " + (String) list.get(zheng).get(0) + " " + (big));
            list.get(fu).set(1, big + small);
            zheng--;
        }
        logic(list, fu, zheng);
    }

}
