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
		temp.next.next.next = new ListNode(10);
		temp.next.next.next.next = new ListNode(20);
		temp.next.next.next.next.next = new ListNode(25);
		temp.next.next.next.next.next.next = new ListNode(30);
		return temp;
	}
	public static void displayList(ListNode temp, String name) {
		System.out.print(name+" : list ->  ");
		while(temp!=null) {
			System.out.print(temp.val+"-");
			temp=temp.next;
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		//init the list
		ListNode root = init();
		displayList(root,"init()");
		ListNode tempRoot = root;

		deleteDup(root);
		displayList(root,"With HashSet");
		
		root = init();
		deleteDup(root);
		displayList(root, "without buffer");
		
		root = init();
		nthToLast(root);
		
		root = init();
		orderList(root);
	}
	//remove duplicate from a listNode
	public static void deleteDup(ListNode root) {
		HashSet<Integer> set = new HashSet<>();
		ListNode prev = new ListNode(0);
		while(root != null) {
			if(set.contains(root.val)) {
				prev.next = root.next;
			}else {
				set.add(root.val);
				prev = root;
			}
			root = root.next;
		}
	}
	public static void deleteDup2(ListNode root) {
		ListNode curr = root;
		while(curr != null) {
			ListNode runner = curr;
			while(runner.next != null) {
				if(runner.next.val == curr.val) {
					runner.next = runner.next.next;
				}else {
					runner = runner.next;
				}
			}
			curr = curr.next;
		}
	}
	
	public static void nthToLast(ListNode root) {
		int k=3;
		ListNode slow=root, fast=root;
		for(int i=0;i<k;i++) {
			if(fast==null) {
				System.out.println("Out of Bound");
				return;
			}
			fast=fast.next;
		}
		while(fast!=null) {
			fast=fast.next;
			slow=slow.next;
		}
		System.out.println("Mid = "+slow.val);
	}
	public static void orderList(ListNode head) {
		int x = 15;
		ListNode dummySmall = new ListNode(0);
		ListNode dummyLarge = new ListNode(0);
		ListNode small = dummySmall;
		ListNode large = dummyLarge;
		while(head!=null) {
			if(head.val<x) {
				small.next = head;
				small = head;
			}else {
				large.next = head;
				large = head;
			}
			head = head.next;
		}
		small.next = dummyLarge.next;
		large.next = null;
		displayList(dummySmall.next,"Rearranged List");

	}
	
}
