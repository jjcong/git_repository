package algorithm.test.exercise.link;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNextLine()) {
            int n = Integer.parseInt(input.nextLine());

            List<String> list = new ArrayList<>();

            for(int i=0;i<n;i++) {
                String temp = input.nextLine();
                if(temp.equals("stop"))
                    break;
                else
                    list.add(temp);
            }

            Collections.sort(list,new StringComparator());;

            for(String e:list)
                System.out.println(e);
        }

    }
    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1,String o2) {
            int len1 = o1.length();
            int len2 = o2.length();
            if(len1!=len2)
                return len1-len2;
            else
                return o1.compareTo(o2);
        }
    }


}
