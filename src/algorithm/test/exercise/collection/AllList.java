package algorithm.test.exercise.collection;

import java.util.ArrayList;
import java.util.List;

public class AllList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        //并集
        list.addAll(list1);
        list.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();


        //交集
        list.retainAll(list1);
        list.stream().forEach(e -> System.out.print(e + " "));


    }
}
