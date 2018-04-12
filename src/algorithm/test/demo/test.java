package algorithm.test.demo;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }

    }

    private static class  OOMObject{}
}
