package algorithm.test.exercise.tree;
/**
 * 判断树A中是否包含树B
 *
 * @author  j_cong
 * @date    2018/04/09
 * @version V1.0
 */
public class HasSubTreeTest {

    public boolean hasSubtree(TreeNode root1,TreeNode root2) {

        boolean result = false;

        if (root1 != null && root2 != null) {

            if (root1.val == root2.val) {
                result = doesTree1HasTree2(root1, root2);
            }

            //遍历左子树
            if (!result) {
                result = doesTree1HasTree2(root1.left, root2);
            }

            //遍历右子树
            if (!result) {
                result = doesTree1HasTree2(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {

        //如果到达树B的叶节点，返回true
        if (root2 == null) {
            return true;
        }

        //如果到达树A的叶节点，false
        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }
}
