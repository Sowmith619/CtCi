package practice;

class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val=val;
		next=null;
	}
}
public class list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root = init();
		display(root, "#Remove elem greater than n\nInput");
		root=removeListNode(root,15);
		display(root, "After Update");
		
		root = init();
		display(root, "\n#Remove duplicates\nInput");
		root = removeListNode_duplicate(root);
		display(root,"Res");
		
		root = init();
		display(root, "\n#Remove All duplicates\nInput");
		root = removeListNode_duplicate2(root);
		display(root,"Res");
		
		root = init();
		display(root, "\n#Remove smallest elem\nInput");
		root = removeSmallestListNode(root);
		display(root,"Res");
		sum();
	}
	public static ListNode init() {
		ListNode temp=new ListNode(5);
		temp.next=new ListNode(15);
		temp.next.next=new ListNode(15);
		temp.next.next.next=new ListNode(25);
		return temp;
	}
	public static void display(ListNode n, String name) {
		System.out.print(name+" : ");
		while(n!=null) {
			System.out.print(n.val+" - ");
			n=n.next;
		}
		System.out.println();
	}
	//optimized: remove ListNode greater/equal than x
	public static ListNode removeListNode(ListNode start, int x) {
		ListNode dummy = new ListNode(0);
		dummy.next = start;
		ListNode curr = start;
		while(curr.next!=null) {
			if(curr.next.val==x)
				curr.next = curr.next.next;
			else
				curr=curr.next;
		}
		return dummy.next;
	}
	//remove duplicate elem from sorted list
	public static ListNode removeListNode_duplicate(ListNode start) {
		ListNode curr = start;
		while(curr.next!=null) {
			if(curr.val == curr.next.val)
				curr.next = curr.next.next;
			else
				curr = curr.next;
		}
		return start;
	}
	//remove ALL duplicate elements from sorted list
	public static ListNode removeListNode_duplicate2(ListNode start) {
		ListNode dummy = new ListNode(0);
		dummy.next = start;
		ListNode prev = dummy;
		ListNode curr = start;
		while(curr!=null) {
			while(curr.next!=null && curr.val==curr.next.val)
				curr=curr.next;
			if(prev.next == curr)
				prev = prev.next;
			else
				prev.next = curr.next;
			curr = curr.next;
		}
		return dummy.next;
	}
	//*cloudera onsite*: remove the smallest ListNode from a list
	public static ListNode removeSmallestListNode(ListNode head) {
		ListNode temp = head;
		ListNode prev = null;
		ListNode smallest = head;
		while(temp!=null) {
			if(temp.next!=null && temp.next.val<smallest.val) {
				smallest = temp.next;
				prev=temp;
			}
			temp=temp.next;
		}
		if(smallest == head)
			head = head.next;
		else
			prev.next = smallest.next;
		return head;
	}
	
	//sum of arr elems
	public static void sum() {
		int[] arr = new int[] {5,10,15};
		System.out.println("\nSum of given arr:"+helper(arr,0));
	}
	public static int helper(int[] arr, int n) {
		if(n==arr.length)
			return 0;
		return arr[n]+helper(arr, n+1);
	}
	
	//remove ListNodes greater than x
	//cloudera submitted code
	public static ListNode removeListNode_C(ListNode start, int x) {
		if(start==null) return start;
		if(start.val>x && start.next==null) return null;
		
		ListNode curr = start;
		ListNode prev = null;
		
		while(curr!=null && curr.val>x) {
			prev=curr;
			curr=curr.next;
		}
		if(prev!=null) prev.next=null;
		ListNode newHead = curr;
		while(curr.next!=null) {
			if(curr.next.val>x)
				curr.next=curr.next.next;
			else
				curr=curr.next;
		}
		return newHead;
	}

}
