package algorithm.test.exercise.笔试真题.阿里巴巴;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int group = scanner.nextInt();
        int row = scanner.nextInt();
        List<Integer> num = new LinkedList<>();


        for (int i = 0; i < row; i++) {

            num.add(scanner.nextInt());
        }

        boolean result = solution(group, num);
        System.out.println(result);


    }

    public static boolean solution(int group, List list) {

        Map<Integer,List> map = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        for (int i = 1; i <= group; i++) {
            res.add(i);
            List list1 = new ArrayList();
            list1.add(2 * i - 1);
            list1.add(2 * i );
            map.put(i, list1);
        }

        for (int j = 0; j < list.size() / 2;j++) {
            for (int k = 0; k < map.size(); k++) {

                List list2 = map.get(k+1);
                for (int s = 0; s < list.size() / 2; s++) {
                    if (list2.contains(list.get(2*s +1)) && list2.contains(list.get(2*s +2))) {
                        return false;
                    }


                }

            }
        }

        return true;

    }


}
