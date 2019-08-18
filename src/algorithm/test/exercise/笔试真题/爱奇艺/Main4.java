package algorithm.test.exercise.笔试真题.爱奇艺;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main4 {
    public static void resetList(List<Integer> dataList){
        dataList.subList(2,4).set(0,40);
        dataList.add(50);
    }

    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<>(Arrays.asList(10,20,30,null));
        resetList(dataList);
        int sum = 0;
        for (Integer i : dataList) {
            sum += i;
        }
        System.out.println(sum);
    }
}
