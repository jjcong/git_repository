package algorithm.test.exercise.笔试真题.去哪儿;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        sc.close();
        System.out.println(" B A 10");
        System.out.println(" C A 10");
        System.out.println(" D A 10");

        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        List<Integer> list = new LinkedList<>();
        jump(arr, list);


        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j) + " ");
        }



    }


    public static  int jump(int[] A, List list) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;

        while(end < A.length - 1){
            int farthest = end;
            for(int i = start; i <= end; i++){ // 本层循环不可漏写！！
                if(i + A[i] > farthest){
                    farthest = i + A[i];
                }
            }
            start = end + 1;
            end = farthest;

            jumps++;// 跳出说明end >= A.length - 1，此后无需再jump++

            list.add(start);
        }

        return jumps;
    }
}
