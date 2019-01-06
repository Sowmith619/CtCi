package java_basic;

class queue2{
	class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
			next = null;
		}
	}
	Node front, rear;
	void add(int n) {
		Node temp = new Node(n);
		if(rear==null) {
			front=rear=temp;
		}else {
			rear.next = temp;
			rear = temp;
		}
		System.out.println(n+" added");
	}
	int remove() {
		if(isEmpty())
			throw new IndexOutOfBoundsException("Queue is Empty");
		Node temp = front;
		front = temp.next;
		if(front==null)
			rear=null;
		return temp.val;
	}
	int peek() {
		if(isEmpty())
			throw new IndexOutOfBoundsException("Queue is Empty");
		return front.val;
	}
	boolean isEmpty() {
		return rear==null;
	}	
}
/* Real Code
 * class queue2{
	class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
			next=null;
		}
	}
	Node front, rear;
	void enqueue(int item) {
		Node temp = new Node(item);
		if(rear==null) {
			front=rear=temp;
		}else {
			rear.next=temp;
			rear=temp;
		}
		System.out.println("Enqueue:"+item);
	}
	int dequeue() {
		if(rear==null)
			throw new IndexOutOfBoundsException("Queue is Empty");
		Node temp = front;
		front = temp.next;
		if(front==null)
			rear=null;
		return temp.val;
	}
	int peek() {
		if(isEmpty())
			throw new IndexOutOfBoundsException("Queue is Empty.");
		return front.val;
	}
	boolean isEmpty() {
		return rear == null;
	}
	
}*/

public class test_queue2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queue2 queue = new queue2();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		System.out.println(queue.remove()+" removed");
		System.out.println(queue.remove()+" removed");
		System.out.println(queue.remove()+" removed");
		
	}

}
