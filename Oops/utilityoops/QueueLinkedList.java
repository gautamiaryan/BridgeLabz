package com.bridgelabz.utilityoops;

public class QueueLinkedList <T>{
	class Node<T>
	{
		 T data;
		 Node<T> link;
		 public Node()
		 {
			 this.data=null;
			 this.link=null;
		 }
		 public T getData()
		 {
			 return data;
		 }
		 public Node<T> getLink()
		 {
			 return link;
		 }
	}
	
	Node<T> rear, front;

	public void enQueue(T data) {
		Node<T> temp = new Node<>();
		temp.data = data;
		if (rear == null) {
			front = temp;
			rear = temp;
			return;
		}
		rear.link = temp;
		rear = temp;
	}

	public T deQueue() {
		T data = null;
		if (front == null) {
			System.out.println("Queue Underflow");
		} else if (front == rear) {
			data = front.data;
			front = null;
			rear = null;
		} else {
			data = front.data;
			front = front.link;
		}
		return data;
	}

	public boolean isEmpty() {
		if (front == null) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		Node<T> node = front;
		while (node != null) {
			System.out.println(node.data);
			node = node.link;
		}
	}

}
