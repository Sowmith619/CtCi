package java_basic;

import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
class arrQueue {
	int arr[];
	int front, rear, size;
	int capacity;
	public Lock lock;
	
	public arrQueue(int capacity) {
		this.capacity = capacity;
		front=size=0;
		rear = capacity-1;
		arr = new int[capacity];				
	}
	synchronized boolean isFull(arrQueue queue) {
		return queue.size==queue.capacity;
	}
	synchronized boolean isEmpty() {
		return this.size==0;
	}
	synchronized void add(int item) {
			if(isFull(this))
	            throw new IndexOutOfBoundsException("Overflow Exception");
			
			rear = (rear+1)%capacity;
			this.arr[this.rear]=item;
			this.size++;
			System.out.println(item+" enqueued rear:"+rear+" Thread->"+Thread.currentThread().getName());
	}
	synchronized int remove() {
		//synchronized(this) {
			if(isEmpty())  //EmptyStackException()
				throw new NoSuchElementException("Underflow Exception");
			int item = arr[front];
			front=(front+1)%capacity;
			size--;
			return item;
		//}
	}
	synchronized int peek() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		return arr[front];
	}
	synchronized int rear() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		return arr[rear];
	}
}

public class test_queue_sync implements Runnable{
	static arrQueue queue = new arrQueue(50);
	public static void main(String[] args) throws InterruptedException {
		
		Thread[] th = new Thread[10]; 
		for(int i=0; i<th.length; i++) { 
			th[i] = new Thread(new test_queue_sync());
			th[i].setName(Integer.toString(i));
			th[i].start();
		}
		for(Thread t:th) {
			t.join();
		}
		
		System.out.println("Size:"+queue.size+":"+queue.peek());
	}
	void createQueue1(){
		queue.add(10);
		queue.add(20);
		queue.add(30);
		
		System.out.println(queue.remove()+" dequeued");
		//System.out.println(queue.remove() +" dequeued");
		//System.out.println(queue.remove() +" dequeued");
	}
	void createQueue2(){
		queue.add(50);
		queue.add(60);
		queue.add(70);

		System.out.println(queue.remove() +" dequeued Thread->"+Thread.currentThread().getName());
		System.out.println(queue.remove() +" dequeued Thread->"+Thread.currentThread().getName());
		//System.out.println(queue.remove() +" dequeued");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("MyRunnable running:"+Thread.currentThread().getName());
		//createQueue();
		if(Integer.parseInt(Thread.currentThread().getName())%2==0) {
			createQueue1();
		}else {
			createQueue2();
		}
	}
}
