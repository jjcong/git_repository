package algorithm.test.tree.bstree;

public class BSTreeTest {

	    private static final int[] ARR = {7, 4, 9, 2, 6, 8, 10, 1, 3, 5};

	    public static void main(String[] args) {

	        BSTree<Integer> tree = new BSTree<>();
	        int length = ARR.length;

	        System.out.print("== 依次添加: ");
	        for (int i = 0; i < length; i++) {
	            System.out.print(ARR[i]+" ");
	            tree.insert(ARR[i]);
	        }

	        System.out.print("\n== 前序遍历:\n");
	        tree.preOrder();

	        System.out.print("\n== 中序遍历:\n");
	        tree.inOrder();

	        System.out.print("\n== 后序遍历:\n");
	        tree.postOrder();
	        System.out.println();

	        System.out.println("== 最小值: "+ tree.minimum());
	        System.out.println("== 最大值: "+ tree.maximum());
	        System.out.println("== 树的详细信息: ");
	        tree.print();

	        System.out.print("\n== 删除根节点: "+ ARR[3]);
	        tree.remove(ARR[3]);

	        System.out.print("\n== 中序遍历: ");
	        tree.inOrder();
	        System.out.println();

	        // 销毁二叉树
	        tree.clear();
	    }

}
