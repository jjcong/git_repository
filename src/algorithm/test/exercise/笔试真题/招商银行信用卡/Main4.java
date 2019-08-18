package algorithm.test.exercise.笔试真题.招商银行信用卡;

import java.util.Scanner;

public class Main4 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(rotatedDigits(n));
        }

    private static int rotatedDigits(int num) {
        int result = 0;
        for(int i = 0; i <= num; ++i){
            if(trueValue(i, false)) ++result;
        }
        return result;
    }
    private static boolean trueValue(int n, boolean checker){
        if(n == 0) return checker;
        int r = n % 10;
        if(r == 3 || r == 4 || r == 7) {
            return false;
        }
        if(r == 2 || r == 5 || r == 6 || r == 9) {
            return trueValue(n/10, true);
        }
        return trueValue(n/10, checker == true ? true : false);
    }

}
