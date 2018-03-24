package algorithm.test.exercise;

import java.util.*;

/**
 * @author:xudajan
 * @date:2018/3/17
 */
public class GenerateID {
    private int count = 0;

    private int getTotal() {
        return count;
    }

    public String generate() {
        StringBuilder s = new StringBuilder();
        int count = getTotal();
        for (int i = 0; i < 4; i++) {
            int j = count % 62;
            char c = getChar(j);
            s.append(c);
            count = count / 62;
        }
        this.count++;
        return String.valueOf(s);
    }

    private char getChar(int i) {
        if (i <= 9) {
            return (char) (48 + i);
        } else if (i >= 10 && i <= 35) {
            return (char) (55 + i);
        } else if (i >= 36 && i <= 61) {
            return (char) (61 + i);
        } else {
            return '0';
        }
    }
}
