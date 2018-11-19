package moderate;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class traversal {

	public static void main(String[] args) {
		// DS | BQ = DFS-->stack, BFS-->Queue
		/*
		 * 			1
		 *		2 		3
		 *    4	  5
		 * */
		/*Depth First Traversals:
		(a) Inorder (Left, Root, Right) : 4 2 5 1 3
		(b) Preorder (Root, Left, Right) : 1 2 4 5 3
		(c) Postorder (Left, Right, Root) : 4 5 2 3 1*/
		
		TreeNode root = new TreeNode(20);
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.print("inorder:\t");
        inorder(root);
        System.out.print("\npre-order:\t");
        preorder(root);
        System.out.print("\npost-order:\t");
        postorder(root);
        System.out.print("\nbfs:\t");
        //bfs(root);
        System.out.print("\nbfs2:\t");
        //bfs2(root);
	}
	public static void inorder(TreeNode root) {
		List<Integer> list = new LinkedList<>();
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
		System.out.println(list);
	}
	public static void preorder(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		while(root!=null || !stack.isEmpty()) {
			if(root!=null) {
				list.add(root.val);
				stack.push(root.right);
				root=root.left;
			}else {
				root=stack.pop();
			}
		}
		System.out.println(list);
	}
	public static void postorder(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		while(root!=null || !stack.isEmpty()) {
			if(root!=null) {
				list.add(0,root.val);
				stack.push(root);
				root=root.right;
			}else {
				root=stack.pop().left;
			}
		}
		System.out.println(list);
	}
	public static void bfs(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			list.add(temp.val);
			if(temp.left!=null) queue.add(temp.left);
			if(temp.right!=null) queue.add(temp.right);
		}
		System.out.println(list);
	}
	public static void bfs2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> res = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> list = new LinkedList<>();
			int level = queue.size();
			for(int i=0;i<level;i++) {
				TreeNode temp = queue.poll();
				list.add(temp.val);
				if(temp.left!=null) queue.add(temp.left);
				if(temp.right!=null) queue.add(temp.right);
			}
			res.add(list);
		}
		
		for(List<Integer> list:res) {
			System.out.print("[ ");
			for(int n:list)
				System.out.print(n+" ");
			System.out.print("]");
		}
	}

}
