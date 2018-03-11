package design.pattern.composite;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 组合模式：测试类
 * @version V1.0.0
 */
public class TreeTest {
	TreeNode root = null;
	
	public TreeTest(String name) {
		root = new TreeNode(name);
	}
	
	public static void main(String[] args) {
		
		TreeTest tree = new TreeTest("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		
		nodeB.add(nodeC);
		tree.root.add(nodeB);
		System.out.println("Build the tree finished!");
	}
}
