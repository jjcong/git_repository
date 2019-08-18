package algorithm.test.exercise.笔试真题.去哪儿;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        Stack<Integer> stack =new Stack <>();

        jump2(arr,stack);

    }

    public static void jump2(int[] arr,Stack <Integer> stack) {

        int jmp = 0;
        int dest = arr.length - 1;

        while(dest != 0){
            for(int i = 0; i < dest; i++){
                if(i + arr[i] >= dest){
                    stack.add(dest-i);
                    dest = i;
                    jmp++;
                    break;
                }
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}
