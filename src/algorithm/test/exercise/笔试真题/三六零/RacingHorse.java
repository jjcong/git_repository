package algorithm.test.exercise.笔试真题.三六零;

/**
 * 类似田忌赛马的算法
 * 
 * @author  j_cong
 * @date    2018/08/29
 * @version V1.0
 */
import java.util.*;

public class RacingHorse {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            aList.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            bList.add(scanner.nextInt());
        }
        System.out.println(getMostBonus(n, aList, bList));
    }

    public static int getMostBonus(int n, List<Integer> aList, List<Integer> bList) {

        Collections.sort(aList);
        Collections.sort(bList);

        int i = 0, j = 0, x = n - 1, y = n - 1, cnt = 0;
        boolean bLast = true;

        while (bLast) {
            //是否是最后一匹马
            if (x == i) {
                bLast = false;
            }

            if (aList.get(x) > bList.get(y)) {//如果田忌当前最好的马可以胜齐王最好的马，那么比一场
                x--;
                y--;
                cnt += 100;
            } else if (aList.get(i) > bList.get(j)) {//如果田忌当前最差的马可以胜齐王最差的马，那么比一场
                i++;
                j++;
                cnt += 100;
            } else {//否则，让田忌最差的马和齐王最好的好比一场
                if (aList.get(i) < bList.get(y)) {
                    cnt -= 100;
                }
                   
                i++;
                y--;
            }
        }
        aList.clear();
        bList.clear();

        return cnt;
    }
}
