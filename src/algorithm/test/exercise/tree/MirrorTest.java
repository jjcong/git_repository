package algorithm.test.exercise.tree;
/**
 * 二叉树的镜像
 * 
 * @author  j_cong
 * @date    2018/04/09
 * @version V1.0
 */
public class MirrorTest {

    public void mirror(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        //交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //遍历左节点
        if (root.left != null) {
            mirror(root.left);
        }
        //遍历右节点
        if (root.right != null) {
            mirror(root.right);
        }

    }
}
