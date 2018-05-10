package algorithm.test.exercise.笔试真题.阿里巴巴;

import java.util.Scanner;

/**
 * 将给定的整数按照中文习惯读出来
 *
 * 1.以10000为小节，小节的结尾即使是0，也不使用“零”。
 *
 * 2.小节内两个非0数字之间要使用“零”。
 *
 * 3.当小节的“千”位是0时，若本小节的前一小节无其他数字，则不用“零”，否则就要用“零”。
 * 
 * @author  j_cong
 * @date    2018/05/06
 * @version V1.0
 */
public class NumberToChineseTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        scanner.close();
        System.out.println(numberToChinese(num));
    }

    public static String numberToChinese(int num) {
        String[] chineseSectionPosition = {"","万","亿","兆"};
        if (num == 0) {
            return "零";
        }
        int sectionPosition = 0;
        String result = new String();
        String sectionChineseNum = new String();

        while (num > 0) {
            int section = num % 10000;
            sectionChineseNum = eachSection(section);
            if (section != 0) {
                sectionChineseNum += chineseSectionPosition[sectionPosition];
            }
            num /= 10000;
            result = sectionChineseNum + result;
            sectionPosition++;
        }
        if ('零' == result.charAt(0)) {
            result = result.substring(1);
        }

        return result;
    }

    public static String eachSection(int num) {
        //中文数字位
        String[] chineseNumber = {"零","一","二","三","四","五","六","七","八","九"};
        //中文数字权位
        String[] chinsesPosition = {"", "十", "百", "千"};
        String res = new String();
        //小节内部制零判断，每个小节内部只能出现一个中文“零”
        boolean zeroFlag = true;

        for (int i = 0; i < 4; i++) {
            int end = num % 10;
            if (0 == end) {
                if (!zeroFlag) {
                    zeroFlag = true;
                    res = chineseNumber[0] + res;
                }
            } else {
                zeroFlag = false;
                res = chineseNumber[end] + chinsesPosition[i] + res;
            }
            num /= 10;
        }

        return res;
    }
}
