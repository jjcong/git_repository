package algorithm.test.exercise;

import network.test.tcp.ip.ServerOutputThread;
import sun.font.FontRunIterator;

import java.util.*;

public class StreamTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Random random = new Random(100);
        for (int i = 0; i < 20 ; i++) {
            list.add(random.nextInt(50));
        }

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection
                .stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out:: println);


        list.stream()
                .sorted()
                .forEach(x-> System.out.print(x + " "));
        System.out.println();

        list.stream().forEach(x-> System.out.print(x + " "));
        System.out.println();

        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(x-> System.out.print(x + " "));

        System.out.println();

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "value" + i);
        }

        map.forEach((key, value) -> System.out.println(key + "->" + value));
    }

}
