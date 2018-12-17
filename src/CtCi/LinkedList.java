package CtCi;

import java.util.HashSet;
import java.util.Stack;

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
		sumList();
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
	public static void sumList() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(5);
		
		ListNode l2 = new ListNode(7);
		l2.next = new ListNode(5);
		//reverseOrder  25+75 => as 52+57 = 109
		ListNode dummy = new ListNode(0);
		ListNode p=l1, q=l2, curr=dummy;
		int sum=0, carry=0;
		while(p!=null || q!=null || carry!=0) {
			int x = p!=null?p.val:0;
			int y = q!=null?q.val:0;
			
			sum = x+y+carry;
			curr.next = new ListNode(sum%10);
			carry = sum/10;
			
			curr = curr.next;
			if(p!=null) p=p.next;
			if(q!=null) q=q.next;
		}
		displayList(dummy.next, "sumList-reverseOrder");
		//inOrder 25+75 => 100
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		p=l1; q=l2;
		while(p!=null) {
			s1.push(p.val);
			p=p.next;
		}
		while(q!=null) {
			s2.push(q.val);
			q=q.next;
		}
		sum=0;
		curr = new ListNode(0);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			if(!s1.isEmpty()) {
				sum+=s1.pop();
			}
			if(!s2.isEmpty()) {
				sum+=s2.pop();
			}
			curr.val = sum%10;
			ListNode head = new ListNode(sum/10);
			head.next = curr;
			curr = head;
			
			sum = sum/10;
		}
		displayList(curr, "sumList-inOrder");
	}
	
}
