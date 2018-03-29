package design.pattern.singleton;
/**
 * 定义一个表示总统的类型President,可以从改类型继承出FrechPresident和AmericanPresident，
 * 这些派生类只能产生一个实例。
 *
 * @author  j_cong
 * @date    2018/03/28
 * @version V1.0
 */
public class FrancePresident extends President {

    private FrancePresident() {}

    private static class Nested {

        private static final  FrancePresident INSTANCE = new FrancePresident();
    }

    public static FrancePresident getInstance() {
        return Nested.INSTANCE;
    }

    public static void main(String[] args) {

        FrancePresident s1 = FrancePresident.getInstance();
        FrancePresident s2 = FrancePresident.getInstance();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
