package algorithm.test.exercise.tree;
/**
 * 判断是否为对称二叉树
 * 通过比较二叉树的前序序列和对称前序遍历判断
 * 
 * @author  j_cong
 * @date    2018/04/09
 * @version V1.0
 */
public class SymmetricalTest {

    public boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    public boolean isSymmetrical(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}
