package java_basic;

class queue2{
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
}

public class test_queue2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queue2 queue = new queue2();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println(queue.dequeue()+" dequeued");
		System.out.println(queue.dequeue()+" dequeued");
		System.out.println(queue.dequeue()+" dequeued");
		
	}

}
