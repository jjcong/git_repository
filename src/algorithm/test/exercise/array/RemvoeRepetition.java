package algorithm.test.exercise.array;

import java.util.*;

public class RemvoeRepetition {

    public static void main(String[] args) {

        int[] arr = {4, 5, 3, 4};
        removeElement(arr, 4);
    }

    public  static int removeElement(int[] A, int elem) {

        List<Integer> list = new LinkedList<>();
        for (int i : A) {
            if (i != elem) {
                list.add(i);
            }
        }

        A = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            A[i] = list.get(i);
        }

        return A.length;
    }


}
