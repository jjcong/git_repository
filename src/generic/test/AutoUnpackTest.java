package generic.test;
/**
 * 自动拆箱测试及陷阱
 *
 * @author  j_cong
 * @date    2018/03/01
 * @version V1.0
 */
public class AutoUnpackTest {

    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == a + b);
//        System.out.println(g.equals(a + b));
    }

}
