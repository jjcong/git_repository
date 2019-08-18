package algorithm.test.exercise;
/**
 * 由字母和数字生成四位不重复的UUID
 * 
 * @author  j_cong
 * @date    2018/04/27
 * @version V1.0
 */
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


    public int[] searchRange(int[] nums, int target) {
        int left = -1;
        int right = -1;
        int[] res = new int[]{left, right};
        int start = 0;
        int end = nums.length;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;

            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                left = mid;
                right = mid;
                while (left > start && nums[left] == nums[left - 1]) {
                    left--;
                }
                while (right < end && nums[right] == nums[right + 1]) {
                    right++;
                }
                return new int[]{left, right};
            }

        }
        return res;
    }
}
