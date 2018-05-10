package algorithm.test.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 去除list中的重复元素
 *
 * @author  j_cong
 * @date    2018/04/27
 * @version V1.0
 */
public class RemoveDuplication {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);

        removeDup(list);
    }
    public static List<Integer> removeDup(List list) {
        Set<Integer> set = new HashSet<Integer>(list);
        list.clear();
        list.addAll(set);

        return list;

    }
}
