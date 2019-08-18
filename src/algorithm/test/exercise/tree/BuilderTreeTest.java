package algorithm.test.exercise.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 后序，中序  ——————> 重建二叉树
 *
 * @author  j_cong
 * @date    2018/07/15
 * @version V1.0
 */
public class BuilderTreeTest {


    public static void main(String[] args) {
        int[] inOrder = {2, 1, 3};
        int[] postOrder = {2, 3, 1};
        BuilderTreeTest test = new BuilderTreeTest();

        test.buildTree(inOrder, postOrder);
    }


    /**
     * 后序，中序 重建二叉树
     *
     * @param inorder     中序
     * @param postorder   后序
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (postorder == null || inorder == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return  inPost(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }



    public TreeNode inPost(int[] post, int pi, int pj, int[] n, int ni, int nj, Map<Integer,Integer> map) {
        if (pi > pj) {
            return null;
        }
        TreeNode head = new TreeNode(post[pj]);
        int index = map.get(post[pj]);

        //注意pi +  (index - ni -1)
        head.left = inPost(post, pi, pi +  (index - ni -1),  n, ni, index - 1, map);
        head.right = inPost(post, pi + (index - ni), pj - 1, n, index + 1, nj, map);

        return head;
    }


    /**
     * 前序，中序 重建二叉树
     *
     * @param pre  前序
     * @param in   中序
     * @return
     */
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
