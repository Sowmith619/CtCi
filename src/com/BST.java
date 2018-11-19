package com;

public class BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(20);
		node.left=new TreeNode(9);
		node.left.left = new TreeNode(5);
		node.left.right = new TreeNode(12);
		node.left.right.left = new TreeNode(11);
		node.left.right.right = new TreeNode(14);
		node.right=new TreeNode(25);
		TreeNode root = node;
		
		System.out.println((inorderSuccessor(root, 14)).val);
		System.out.println((inorderPredecessor(root, 11)).val);
		System.out.println(search(root, 15));
	}
	
	public static TreeNode inorderSuccessor(TreeNode root, int val) {
	    TreeNode succ = null;
	    while(root!=null) {
	        if(root.val > val) {
	        	succ = root;
	        	root = root.left;
	        }
	        else root = root.right;
	    }
	    return succ;
	}
	
	public static TreeNode inorderPredecessor (TreeNode root, int val) {
	    TreeNode pre = null;
	    while(root!=null) {
	        if(root.val < val) {
	        	pre = root;
	        	root = root.right;
	        }
	        else root = root.left;
	    }
	    return pre;
	}
	public static boolean search(TreeNode root, int n) {
		TreeNode curr = root;
		while(curr!=null) {
			if(curr.val==n)
				return true;
			else if(curr.val>n) {
				if(curr.left!=null)
					curr=curr.left;
				else
					break;
			}else {
				if(curr.right!=null)
					curr=curr.right;
				else
					break;
			}
		}
		return false;
	}
	/*
	 Node findInOrderSuccessor(Node inputNode) {
      // your code goes here 
      //Node node = findNode(inputNode, inputNode.key);
      if(inputNode.right!=null){
        //find the node with min in right subtree
           inputNode = inputNode.right;
           while(inputNode.left != null)
                inputNode = inputNode.left;
        
           return inputNode;
      }
      // 5, 9, 11, 12, 14, 20, 25
      Node ancestor = inputNode.parent;
      Node child = inputNode;
      
      while(ancestor!=null && child==ancestor.right){
            child=ancestor;
            ancestor = child.parent;
      }
      
      return ancestor;      
      
      
    }
	 * 
	 * */
}
