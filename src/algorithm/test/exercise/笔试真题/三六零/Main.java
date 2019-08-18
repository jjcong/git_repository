package algorithm.test.exercise.笔试真题.三六零;
/**
 * 给定几个坐标点，求能覆盖所有点的最小正方形（正方形平行于坐标轴）
 * 
 * @author  j_cong
 * @date    2018/08/27
 * @version V1.0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            firstList.add(scanner.nextInt());
            secondList.add(scanner.nextInt());
        }

        long minX = getMin(firstList);
        long maxX = getMax(firstList);

        long minY = getMin(secondList);
        long maxY = getMax(secondList);

        long res = Math.max(maxX - minX, maxY- minY);

        System.out.println(res * res);
    }

    public static int getMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i : list) {
            max = i > max ? i : max;
        }

        return max;
    }

    public static int getMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int i : list) {
            min = i > min ? min : i;
        }
        return min;
    }

}