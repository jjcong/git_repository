package others;

public class Test1 {

    public static void main(String[] args) {
        Long a = 121391L;
        Double b = a.doubleValue()/1024;
        System.out.println(b);
       System.out.println(String.format("%.4f", b ));
    }
}
