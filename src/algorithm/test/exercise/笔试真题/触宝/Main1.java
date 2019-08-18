package algorithm.test.exercise.笔试真题.触宝;
import java.util.*;
import java.util.Stack;
/**
 * 按照1+6/3=2   +，-运算符> * /
 * 
 * @author  j_cong
 * @date    2018/09/04
 * @version V1.0
 */

public class Main1 {
    public static Long evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<Long> stackOfNum = new Stack<>();

        Stack<Character> stackOfOps = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sbuf.append(tokens[i++]);
                }
                i--; // 回退一位
                stackOfNum.push(Long.valueOf(sbuf.toString()));
            }


            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

                while (!stackOfOps.empty() && hasPrecedence(tokens[i], stackOfOps.peek()))
                    stackOfNum.push(caculate(stackOfOps.pop(), stackOfNum.pop(), stackOfNum.pop()));

                stackOfOps.push(tokens[i]);
            }
        }

        while (!stackOfOps.empty())
            stackOfNum.push(caculate(stackOfOps.pop(), stackOfNum.pop(), stackOfNum.pop()));

        return stackOfNum.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {

        if ((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/'))
            return false;
        else
            return true;
    }

    public static Long caculate(char op, Long b, Long a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0L;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(evaluate(input));

    }
}
