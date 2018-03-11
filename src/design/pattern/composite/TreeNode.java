package design.pattern.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 组合模式：树节点
 * @version V1.0.0 
 */
public class TreeNode {

	private String name;
	private TreeNode parent;
	private Vector<TreeNode> childen = new Vector<>();
	
	public TreeNode(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	
	//添加孩子节点
	public void add(TreeNode node) {
		childen.add(node);
	}

	// 删除孩子节点
	public void remove(TreeNode node) {
		childen.remove(node);
	}
	
	// 取得孩子节点
	public Enumeration<TreeNode> getChilden(TreeNode parent) {
		return childen.elements();
	}

	
}
