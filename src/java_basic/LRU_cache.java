package java_basic;

import java.util.HashMap;

class DLinkedNode{
	int key;
	int value;
	DLinkedNode prev;
	DLinkedNode next;
}
public class LRU_cache {
	public void addNode(DLinkedNode node) {
		node.prev=head;
		node.next=head.next;
		head.next.prev=node;
		head.next=node;
	}
	public void removeNode(DLinkedNode node) {
		DLinkedNode prev = node.prev;
		DLinkedNode next = node.next;
		prev.next = next;
		next.prev = prev;
	}
	public void moveToHead(DLinkedNode node) {
		removeNode(node);
		addNode(node);
	}
	public DLinkedNode popTail() {
		DLinkedNode res = tail.prev;
		removeNode(res);
		return res;
	}
	int size, capacity;
	HashMap<Integer, DLinkedNode> map = new HashMap<>();
	DLinkedNode head, tail;
	LRU_cache(int capacity){
		size=0;
		this.capacity=capacity;
		
		head=new DLinkedNode();
		head.prev=null;
		tail=new DLinkedNode();
		tail.next=null;
		head.next=tail;
		tail.prev=head;
	}
	
	public int get(int key) {
		DLinkedNode node = map.get(key);
		if(node==null) {
			return -1;
		}else {
			moveToHead(node);
			return node.value;
		}
	}
	public void put(int key, int value) {
		DLinkedNode node = map.get(key);
		if(node==null) {
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
			map.put(key, newNode);
			addNode(newNode);
			size++;
			if(size>capacity) {
				DLinkedNode tail = popTail();
				map.remove(tail.key);
				size--;
			}
		}else {
			node.value=value;
			map.put(key, node);
			moveToHead(node);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LRU_cache obj = new LRU_cache(5);
		 System.out.println(obj.get(5));
		 obj.put(1,11);
		 obj.put(2,22);
		 System.out.println(obj.get(1));
		 System.out.println(obj.get(2));
		 obj.put(3,33);
		 obj.put(4,44);
		 obj.put(5,55);
		 obj.put(6,66);
		 obj.put(7,77);
		 System.out.println(obj.size); 
		 DLinkedNode temp = obj.head;
		 while(temp!=null) {
			 System.out.print(":"+temp.key);
			 temp=temp.next;
		 }
		 System.out.println("\n"+obj.get(2));
	}
}
