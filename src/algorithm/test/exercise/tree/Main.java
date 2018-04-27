package algorithm.test.exercise.tree;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 二叉树的序列化和反序列化
 * 
 * @author  j_cong
 * @date    2018/04/25
 * @version V1.0
 */
public class Main {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Main main = new Main();
        main.Serialize(root);

    }


    String Serialize(TreeNode root) {
        if (root == null) {
            return "$,";
        }
        String res = root.val + ",";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
    }
    TreeNode Deserialize(String str) {

        String[] values = str.split(",");
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }

        return reconPreOrder(queue);
    }

    public TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (",".equals(value)) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);

        return head;
    }


}
