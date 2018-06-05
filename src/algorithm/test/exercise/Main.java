package algorithm.test.exercise;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String aString = scanner.nextLine();
        ArrayList<Character> characters = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < aString.length(); i++) {
            if (!characters.contains(aString.charAt(i))) {
                characters.add(aString.charAt(i));
            }
            Character character = aString.charAt(i);
            if (!map.containsKey(character)) {
                map.put(character, 1);
                if (max < 1) {
                    max = 1;
                }
            } else {
                Integer integer = map.get(character);
                integer = integer + 1;
                map.put(character, integer);
                if (max < integer) {
                    max = integer;
                }
            }
        }
        char[] cs = new char[characters.size()];
        for (int i = 0; i < characters.size(); i++) {
            cs[i] = characters.get(i);
        }
        Arrays.sort(cs);
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < cs.length; j++) {
                Character character = cs[j];
                Integer integer = map.get(character);
                if (integer > 0) {
                    System.out.print(character);
                    integer = integer - 1;
                    map.put(character, integer);
                }
            }
        }


    }


}