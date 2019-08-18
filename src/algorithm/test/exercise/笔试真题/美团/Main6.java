package algorithm.test.exercise.笔试真题.美团;


import java.util.*;

public class Main6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        HashMap<Integer, ArrayList<HashMap<Integer, Integer>>> map = new HashMap<>();
        for (int i = 0; i < length - 1; i++) {
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            if (map.containsKey(num1)) {
                HashMap<Integer, Integer> map2 = new HashMap<>();
                map2.put(num2, 1);
                map.get(num1).add(map2);
            } else {
                ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();
                HashMap<Integer, Integer> map2 = new HashMap<>();
                map2.put(num2, 1);
                list.add(map2);
                map.put(num1, list);
            }
        }
        System.out.println(length);
    }
}
