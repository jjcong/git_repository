package algorithm.test.exercise.tree;

import java.util.*;

/**
 * 遍历树的前序、中序、后序
 *
 * @author  j_cong
 * @date    2018/03/30
 * @version V1.0
 */
public class OrderTest {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;


        preorderTraversal_1(root);
        System.out.println(maxDepth(root));

    }


    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here

        if (root == null) {
            return result;
        }

        result.add(root.val);

        if (root.left != null) {
            preorderTraversal(root.left);
        }

        if (root.right != null) {
            preorderTraversal(root.right);
        }

        return result;

    }

    /**
     * 前序非递归方式，利用栈
     * 思路：对于任意节点T，访问这个节点并压入栈中，然后访问节点的左子树，
     *      遍历完左子树后，取出栈顶的节点T，再先序遍历T的右子树
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal_1(TreeNode root) {

        //当前节点
        TreeNode cur = root;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        //栈不为空时，或者cur不为空时循环
        while (cur != null || !stack.isEmpty()) {
            //当前节点不为空。访问并压入栈中。并将当前节点赋值为左儿子
            //当前节点为空：
            //  1、当p指向的左儿子时，此时栈顶元素必然是它的父节点
            //  2、当p指向的右儿子时，此时栈顶元素必然是它的爷爷节点
            //取出栈顶元素，赋值为right
            if (cur != null) {
                stack.push(cur);
                result.add(cur.val);
                cur = cur.left;
            } else {
                //取出栈顶结点作为当前节点
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return result;
    }

    /**
     * 中序遍历---非递归方式
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }

        return result;

    }

    /**
     * 层次遍历---非递归方式
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> tree = new ArrayList<>();

        if (root == null) {
            return tree;
        }

        //将指定的元素插入到此队列中
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                //检索并删除此队列的头，如果队列为空，返回null
                TreeNode head = queue.poll();
                list.add(head.val);

                if (head.left != null) {
                    queue.offer(head.left);
                }

                if (head.right != null) {
                    queue.offer(head.right);
                }
            }

            tree.add(list);
        }

        return  tree;
    }



    /**
     * 树的最大深度（递归实现）
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int result = leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;

        return result;
    }
}
