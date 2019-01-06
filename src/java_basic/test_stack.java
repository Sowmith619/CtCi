package java_basic;

import java.util.NoSuchElementException;

class stack{
	int[] arr;
	int top;
	int capacity;
	stack(int capacity){
		this.capacity = capacity;
		arr = new int[capacity];
		top=-1;
	}
	void push(int item) {
		arr[++top]=item;
		System.out.println(item+" pushed");
	}
	int pop() {
		if(isEmpty())
			throw new IndexOutOfBoundsException("Stack is Empty");
		int temp = arr[top--];
		return temp;
	}
	int peek() {
		if(isEmpty())
			throw new IndexOutOfBoundsException("Stack is Empty");
		return arr[top];
	}
	boolean isEmpty() {
		return top<0;
	}
}




/*class stack{
	int[] arr;
	int top;
	int capacity;
	public stack(int capacity){
		this.capacity=capacity;
		arr = new int[capacity];
		top=-1;
	}
	boolean isFull() {
		return this.top==this.capacity;
	}
	boolean isEmpty() {
		return top<0;
	}
	boolean push(int item) {
		if(isFull())
			throw new IndexOutOfBoundsException("Stack full");
		arr[++top]=item;
		return true;
	}
	int pop() {
		if(isEmpty())
			throw new NoSuchElementException("Stack is Empty");
		int x = arr[top--];
		return x;
	}
}*/
public class test_stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack stack = new stack(10);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
