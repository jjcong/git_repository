package algorithm.test.exercise.笔试真题.爱奇艺;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] arr = str1.split(" ");
        int N = Integer.valueOf(arr[0]);
        int M = Integer.valueOf(arr[1]);
        int P = Integer.valueOf(arr[2]);
        String str2 = sc.nextLine();
        String[] arr2 = str2.split(" ");
        HashMap<Integer, Integer> foodMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            foodMap.put(i + 1, Integer.valueOf(arr2[i]));
        }
        for (int i = 0; i < M; i++) {
            String strM = sc.nextLine();
            String[] arrM = strM.split(" ");
            int number = foodMap.get(Integer.valueOf(arrM[1]));
            if ("A".equals(arrM[0])) {
                foodMap.put(Integer.valueOf(arrM[1]), number + 1);
            } else {
                foodMap.put(Integer.valueOf(arrM[1]), number - 1);
            }
        }
        Map sortedMap = sortByComparator(foodMap);
        int value = (Integer) sortedMap.get(P);
        int rank = 0;
        for (Object key : sortedMap.keySet()) {
            if ((Integer) sortedMap.get(key) > value) {
                rank++;
            } else if ((Integer) sortedMap.get(key) == value) {
                rank++;
                System.out.println(rank);
                break;
            }
        }
    }

    public static Map<Integer, Integer> sortByComparator(Map<Integer, Integer> unsortMap) {
        List<Integer> list = new LinkedList(unsortMap.entrySet());

        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });
        Map sortedMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
