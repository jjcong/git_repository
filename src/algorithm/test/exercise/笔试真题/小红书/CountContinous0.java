package algorithm.test.exercise.笔试真题.小红书;

public class CountContinous0 {

    public static void main(String[] args) {
        int n = 11;
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += numOfZero(i + 1);
        }
        System.out.println(num);
    }


    public static long numOfZero(long num) {
        long count = 0;
        while (num != 0) {
            count += num / 5;
            num /= 5;
        }
        return count;
    }

    public static long factorial(int n) {

        if (1 == n) {
            return  1;
        }

        return n * factorial(n - 1);
    }
}
