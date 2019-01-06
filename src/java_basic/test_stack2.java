package java_basic;

class stack2{
	class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
			next=null;
		}
	}
	Node top;
	void push(int n) {
		Node temp = new Node(n);
		temp.next = top;
		top = temp;
		System.out.println(n+" pushed");
	}
	int pop() {
		if(isEmpty())
			System.out.println("Stack is Empty");
		Node temp = top;
		top = temp.next;
		return temp.val;
	}
	int peek() {
		if(isEmpty())
			System.out.println("Stack is Empty");
		return top.val;
	}
	boolean isEmpty() {
		return top==null;
	}
}




/*Real Code
 * class Stack2{
	class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
			next=null;
		}
	}
		Node top;
		void push(int item) {
			Node temp = new Node(item);
			temp.next=top;
			top=temp;
			System.out.println(item+" pushed");
		}
		int pop() {
			if(isEmpty())
				throw new IndexOutOfBoundsException("Stack is Empty");
			Node temp = top;
			top=temp.next;
			return temp.val;
		}
		boolean isEmpty() {
			return top==null;
		}
		int peek() {
			if(isEmpty())
				throw new IndexOutOfBoundsException("Stack is empty");
			return top.val;
		}
}*/
public class test_stack2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack2 stack = new stack2();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.pop()+" popped");

		
	}

}
