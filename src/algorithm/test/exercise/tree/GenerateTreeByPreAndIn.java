package algorithm.test.exercise.tree;

import java.util.HashMap;
import java.util.Map;
/**
 * 根据前序和中序重建
 * 
 * @author  j_cong
 * @date    2018/05/14
 * @version V1.0
 */
public class GenerateTreeByPreAndIn {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        GenerateTreeByPreAndIn test = new GenerateTreeByPreAndIn();
        test.reConstructBinaryTree(pre, in);
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        
        if (pre == null || in == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    public TreeNode preIn(int[] pre, int pi, int pj, int[] n, int ni, int nj, Map<Integer, Integer> map) {
        if (pi > pj) {
            return null;
        }
        TreeNode head = new TreeNode(pre[pi]);
        int index = map.get(pre[pi]);
        head.left = preIn(pre, pi + 1, pi + index - ni, n, ni, index - 1, map);
        head.right = preIn(pre, pi + index - ni + 1, pj, n, index + 1, nj, map);

        return head;
    }


}
