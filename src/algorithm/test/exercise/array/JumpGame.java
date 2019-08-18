package algorithm.test.exercise.array;

/**
 * 跳跃游戏，是否能跳到最后
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/10/05
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int reach = 0;
        int i = 0;
        for (; i <= reach && i < nums.length; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return i == nums.length;

    }
}
