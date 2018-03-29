package design.pattern.singleton;
/**
 *  定义一个表示总统的类型President,可以从改类型继承出FrechPresident和AmericanPresident， 这些派生类只能产生一个实例。
 *
 * @author  j_cong
 * @date    2018/03/28
 * @version V1.0
 */
public class President {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
