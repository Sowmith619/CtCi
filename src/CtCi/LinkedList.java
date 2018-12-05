package CtCi;

import java.util.HashSet;

class ListNode{
	int val;
	ListNode next;
	ListNode (int val){
		this.val = val;
		this.next = null;
	}	
}

public class LinkedList {
	public static ListNode init() {
		ListNode temp = new ListNode(5);
		temp.next = new ListNode(10);
		temp.next.next = new ListNode(15);
		temp.next.next.next = new ListNode(15);
		temp.next.next.next.next = new ListNode(20);
		return temp;
	}
	public static void displayList(ListNode temp) {
		System.out.print("ListNode ->  ");
		while(temp!=null) {
			System.out.print(temp.val+"-");
			temp=temp.next;
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		//init the list
		ListNode root = init();
		displayList(root);
		ListNode tempRoot = root;

		deleteDup(root);
		displayList(root);
	}
	//remove duplicate from a listNode
	public static void deleteDup(ListNode root) {
		HashSet<Integer> set = new HashSet<>();
		ListNode previous = new ListNode(0);
		previous.next = root;
		while(root!=null) {
			if(set.contains(root.val)) {
				previous.next=root.next;
			}else {
				set.add(root.val);
				previous = root;
			}
			root=root.next;
		}
	}

	
	
	
}
