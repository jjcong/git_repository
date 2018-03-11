package thread.test;
/**
 * @ Author:  j_cong
 * @ Date:    2017-10-24
 * @ Version: V1.0
 * @ Desc:    指令重排序测试
 */
public class ReorderTest {

    public static void main(String[] args) {

        int a = 1;
        int b = 2;

        try {
            b = 1 / 0;
            a = 3;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("a = " + a);
        }
    }
}
