package algorithm.test.exercise.笔试真题.顺丰科技;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class ComparatorMe implements Comparator<Chenji> {

    @Override
    public int compare(Chenji o1, Chenji o2) {
        return o1.xh - o2.xh;
    }
}

class Chenji {
    int cj8 = 0;
    int cj1 = 0;
    int cjq = 0;
    int cjt = 0;
    int xh = 0;
    String s8;
    String s1;
    String sq;
    String st;

    public Chenji(int cj8, int cj1, int cjq, int cjt, int xh) {

        this.cj8 = cj8;
        this.cj1 = cj1;
        this.cjq = cjq;
        this.cjt = cjt;
        this.xh = xh;
        if (cj8 <= 215) {
            s8 = "GREAT";
        }
        if (cj8 >= 216 && cj8 <= 224) {
            s8 = "GOOD";
        }
        if (cj8 >= 225 && cj8 <= 231) {
            s8 = "PASS";
        }
        if (cj8 >= 232) {
            s8 = "FAIL";
        }
        if (cj1 <= 12) {
            s1 = "GREAT";
        }
        if (cj1 >= 121 && cj8 <= 124) {
            s1 = "GOOD";
        }
        if (cj1 >= 125 && cj8 <= 129) {
            s1 = "PASS";
        }
        if (cj1 >= 232) {
            s8 = "FAIL";
        }
        if (cjq >= 104) {
            sq = "GREAT";
        }
        if (cjq >= 96 && cjq <= 103) {
            sq = "GOOD";
        }
        if (cjq >= 87 && cjq <= 95) {
            sq = "PASS";
        }
        if (cjq <= 86) {
            sq = "FAIL";
        }
        if (cjt >= 266) {
            st = "GREAT";
        }
        if (cjt >= 256 && cjt <= 265) {
            st = "GOOD";
        }
        if (cjt >= 246 && cjt <= 255) {
            st = "PASS";
        }
        if (cjt <= 255) {
            st = "FAIL";
        }

    }

}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        String s1 = "";
        String s2 = sc.nextLine();

        int count = 1;
        while (!s2.equals("end")) {
            count++;
            s1 = s1 + "fenli" + s2;
            s2 = sc.nextLine();
        }
	/*	6789  11s9 2m22 240cm 10.5m
		8901  12s 9.7m 2m18 260cm
		0002  2m22 10m 258cm 11s5
		5678  11.1m 266cm 2m10 12s3
		7890  12s4 10.2m 270cm 2m08
		end*/
        count++;
        String a1[] = s1.split("fenli");
        int xuehao[] = new int[count];
        int[] yibai = new int[count];
        int[] babai = new int[count];
        int[] tiao = new int[count];
        int[] qiu = new int[count];
        for (int i = 1; i < count; i++) {
            String b = a1[i];
            String b2[] = b.split(" ");
            for (int j = 0; j < 4; j++) {
                if (b2[j].contains("s")) {
                    if (b2[j].endsWith("s")) {
                        b2[j] = b2[j] + "0";
                    }
                    String c = b2[j].replace("s", "");
                    yibai[i] = Integer.parseInt(c);

                } else if (b2[j].contains(".")) {
                    String c = b2[j].replaceAll(".", "");
                    c = c.replace("m", "");

                    qiu[i] = Integer.parseInt(c);

                } else if (b2[j].contains("m") && !b2[j].contains(".") && !b2[j].contains("c")) {

                    String c = b2[j].replace("m", "");

                    babai[i] = Integer.parseInt(c);

                } else if (b2[j].contains("cm")) {
                    String c = b2[j].replace("cm", "");
                    babai[i] = Integer.parseInt(c);

                } else {
                    xuehao[i] = Integer.parseInt(b2[j]);
                }

            }
        }
        Chenji[] cc = new Chenji[count - 1];
        for (int i = 0; i < count; i++) {
            cc[i] = new Chenji(babai[i + 1], yibai[i + 1], qiu[i + 1], tiao[i + 1], xuehao[i + 1]);
        }
        Arrays.sort(cc, new ComparatorMe());
        System.out.println("NO." + " 100M" + " 800M" + " JUMP" + " BALL");
        for (int i = 0; i < count; i++) {
            System.out.println(cc[i].xh + " " + cc[i].s1 + " " + cc[i].s8 + " " + cc[i].st + " " + cc[i].sq);
        }
    }

}

