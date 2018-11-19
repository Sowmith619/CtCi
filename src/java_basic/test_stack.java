package java_basic;

import java.util.NoSuchElementException;


class stack{
	int[] arr;
	int top;
	int capacity;
	public stack(int capacity) {
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
		if(top==capacity)
			throw new IndexOutOfBoundsException("Stack is Full");
		arr[++top]=item;
		return true;
	}
	int pop() {
		if(isEmpty())
			throw new NoSuchElementException("Stack is Empty");
		int x = arr[top--];
		return x;
	}
}



/*class arrStack{
	int[] arr;
	int top;
	int capacity;
	public arrStack(int capacity){
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
		System.out.println(stack.push(10));
		System.out.println(stack.push(20));
		System.out.println(stack.push(30));
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
