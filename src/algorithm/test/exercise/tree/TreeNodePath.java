package algorithm.test.exercise.tree;

import java.util.ArrayList;
/**
 *  输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *  路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 * 
 * @author  j_cong
 * @date    2018/04/10
 * @version V1.0
 */
public class TreeNodePath {
    // 存放所有路径
    ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    // 用于遍历
    ArrayList<Integer> list = new ArrayList<Integer>();
    int num = 0;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target)
    {

        if (root == null)
        {
            return lists;
        }

        num += root.val;
        list.add(root.val);
        // 如果此时路径长度值刚好等于目标值，并且此时所在结点为叶子结点(路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径),路径存入lists
        if (num == target && root.left == null && root.right == null)
        {
            // 存放路径结点值
            ArrayList<Integer> path = new ArrayList<Integer>();
            for (int i = 0; i < list.size(); i++)
            {
                path.add(list.get(i));
            }
            lists.add(path);
        }
        // 先遍历左子树
        if (num < target && root.left != null)
        {
            FindPath(root.left, target);
        }
        // 左子树遍历结束，遍历右子树
        if (num < target && root.right != null)
        {
            FindPath(root.right, target);
        }
        // 去掉这个结点值
        num -= root.val;
        // 删除该结点，返回到父结点
        list.remove(list.size() - 1);
        return lists;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(1);
        int target = 14;
        TreeNodePath s = new TreeNodePath();
        ArrayList<ArrayList<Integer>> lists = s.FindPath(root, target);

        for (int i = 0; i < lists.size(); i++)
        {
            System.out.println(lists.get(i));
        }
    }
}
