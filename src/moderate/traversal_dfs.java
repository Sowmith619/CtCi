	package moderate;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;



class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){ val=x; }
}
	/*Depth First Traversals:
	(a) Inorder (Left, Root, Right) : 4 2 5 1 3
	(b) Preorder (Root, Left, Right) : 1 2 4 5 3
	(c) Postorder (Left, Right, Root) : 4 5 2 3 1*/
	/*
	 * 			1
	 *		2 		3
	 *    4	  5
	 */

public class traversal_dfs {
	public static void display(List<Integer> list, String name) {
		System.out.print(name+" : ");
		for(int n:list)
			System.out.print(n+" ");
		System.out.println();
	}
	public static List<Integer> init() {
		return new LinkedList<>();
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        //Iterative        
		List<Integer> list = new LinkedList<>();
		list=inorderTraversal(root);
		display(list,"inorderTraversal");
		//PreOrder Traversal
		list=preorderTraversal(root);
		display(list,"preorderTraversal");	
		//PostOrder Traversal
		list=postorderTraversal(root);
		display(list,"postorderTraversal");	
		
		System.out.println("\nRecursion Solution");
		//Recursion
		//InorderTraversal
		list = init();
		inorderTraversal_recur(root, list);
		display(list,"inorderTraversal_recur");		
		//PreOrder Traversal
		list = init();
		preorderTraversal_recur(root, list);
		display(list,"preorderTraversal_recur");		
		//PostOrder Traversal
		list = init();
		postorderTraversal_recur(root, list);
		display(list,"postorderTraversal_recur");
	}
	//ITERATIVE SOLUTION
	public static List<Integer> inorderTraversal(TreeNode root) {
	    // 5, 9, 11, 12, 14, 20, 25
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new LinkedList<>();

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
	public static List<Integer> preorderTraversal(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new LinkedList<>();
		
		while(root!=null || !stack.isEmpty()) {
			if(root!=null) {
				list.add(root.val);
				stack.push(root.right);
				root=root.left;
			}else {
				root=stack.pop();
			}
		}
		return list;
	}
	public static List<Integer> postorderTraversal(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		LinkedList<Integer> list = new LinkedList<>();
		
		while(root!=null || !stack.isEmpty()) {
			if(root!=null) {
				list.addFirst(root.val);
				stack.push(root);		
				root=root.right;
			}else {
				root = stack.pop().left;
			}
		}
		return list;
	}
	
	//RECURSIVE SOLUTION
	public static void inorderTraversal_recur(TreeNode root, List<Integer> res) {
		if(root==null) return;
		inorderTraversal_recur(root.left, res);
		//System.out.println(root.val);
		res.add(root.val);
		inorderTraversal_recur(root.right, res);
	}
	
	public static void preorderTraversal_recur(TreeNode root, List<Integer> res) {
		if(root==null) return;
		res.add(root.val);
		preorderTraversal_recur(root.left, res);
		preorderTraversal_recur(root.right, res);
	}
	
	public static void postorderTraversal_recur(TreeNode root, List<Integer> res) {
		if(root==null) return;
		postorderTraversal_recur(root.left, res);
		postorderTraversal_recur(root.right, res);
		res.add(root.val);
	}
	
}
