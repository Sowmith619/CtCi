package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left= new TreeNode(4);
		root.left.left= new TreeNode(3);
		root.right= new TreeNode(6);
		root.right.right= new TreeNode(7);
		List<Integer> l = inorderTraversal(root);
		for(int n:l)
			System.out.println(n);
		//IsValidBST
		System.out.println("inOrderTraversal isValidBST(root)::"+isValidBST(root));
		System.out.println("Max/Min isValidBST(root)::"+isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
	}
	public static List<Integer> inorderTraversal(TreeNode root){
		if(root==null) return null;
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while(root!=null || !stack.isEmpty()) {
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			list.add(root.val);
			root=root.right;
		}
		return list;
	}
	//left<=curr<right
	public static boolean isValidBST(TreeNode root) {
		if(root==null) return true;
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		TreeNode prev = null;
		while(root!=null || !stack.isEmpty()) {
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			if(prev!=null && prev.val>=root.val) return false; 
			root=root.right;
		}
		return true;
	}
	
	public static boolean isValidBST(TreeNode root, long min, long max) {
		if(root==null) return true;
		if(root.val<=min || root.val>=max) return false;
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}

}
