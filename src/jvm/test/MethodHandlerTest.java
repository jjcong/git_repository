package jvm.test;

import static java.lang.invoke.MethodHandles.lookup;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
 * 使用MethodHandler来解决字类访问上上父类的问题
 *
 * @author  j_cong
 * @date    2018/02/27
 * @version V1.0
 */
public class MethodHandlerTest {

    class GrandFather {
        void thinking() {
            System.out.println("I am grandfather!");
        }
    }

    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("I am father!");
        }
    }

    class Son extends Father {

        @Override
        void thinking() {
            try {
                MethodType methodType = MethodType.methodType(void.class);
                MethodHandle methodHandle = lookup().findSpecial(GrandFather.class,
                        "thinking", methodType, getClass());
                methodHandle.invoke(this);

            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        (new MethodHandlerTest().new Son()).thinking();
    }

}
