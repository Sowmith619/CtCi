package moderate;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class traversal_bfs {
	public static void display(List<Integer> list, String name) {
		System.out.print(name+" :");
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

		List<Integer> list = new LinkedList<>();
		bfs(root,list);
		display(list,"Level Order Tree Traversal");
		bfs2(root);
	}
	public static void bfs(TreeNode root, List<Integer> list) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			list.add(temp.val);
			if(temp.left!=null) queue.add(temp.left);
			if(temp.right!=null) queue.add(temp.right);
		}
	}
	public static void bfs2(TreeNode root) {
		List<List<Integer>> wrapList = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> sublist = new LinkedList<>();
			int level = queue.size();
			for(int i=0;i<level;i++) {
				TreeNode temp = queue.poll();
				sublist.add(temp.val);
				if(temp.left!=null) queue.add(temp.left);
				if(temp.right!=null) queue.add(temp.right);
			}
			wrapList.add(sublist);
		}
		
		for(List<Integer> l:wrapList) {
				System.out.print("[ ");
				for(int n:l)
					System.out.print(n+" ");
				System.out.print("]");
		}
	}
}
