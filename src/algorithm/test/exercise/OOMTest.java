package algorithm.test.exercise;

import java.util.ArrayList;

/**
 * 溢出测试
 *
 * @author  j_cong
 * @date    2018/06/05
 * @version V1.0
 */
public class OOMTest {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();

        while (true) {
            arrayList.add(new int[20480]);
        }

    }

}
