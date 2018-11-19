package com;

import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(2);
		node.left = new TreeNode(3);
		node.left.left = new TreeNode(1);
		node.right = new TreeNode(4);
		
		List<List<TreeNode>> lists = new LinkedList<>();
		createLevelLinkedList(node, lists, 0);
		
		for(List<TreeNode> l1:lists) {
			for(TreeNode l2:l1)
				System.out.print(l2.val + " ");
			System.out.println("");
		}
	}
	//pre-order traversal
	public static void createLevelLinkedList(TreeNode node, List<List<TreeNode>> lists, int level) {
		if(node==null) return;
		List<TreeNode> list = null;
		if(lists.size()==level) {
			list = new LinkedList<>();
			lists.add(new LinkedList<>(list));
		}else
			list = lists.get(level);
		list.add(node);
		createLevelLinkedList(node.left, lists, level+1);
		createLevelLinkedList(node.right, lists, level+1);
	}
}
