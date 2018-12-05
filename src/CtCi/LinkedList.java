package CtCi;

class ListNode{
	int val;
	ListNode next;
	ListNode (int val){
		this.val = val;
		this.next = null;
	}	
}

public class LinkedList {
	
	public static void main(String[] args) {
		ListNode root = init();
		ListNode dummt = new ListNode(0);
		
		System.out.print("Vals :  ");
		while(root!=null) {
			System.out.print(root.val+"-");
			root=root.next;
		}
	}
	
	public static ListNode init() {
		ListNode temp = new ListNode(5);
		temp.next = new ListNode(10);
		temp.next.next = new ListNode(15);
		temp.next.next.next = new ListNode(20);
		
		return temp;
	}
	
	
	
}
