package com.bridgelabz.utilityoops;

public class StackLinkedList<T> {
	
	private class Node{
		T data;
		Node next;
	}
	Node top;
	StackLinkedList(){
		this.top=null;
	}

	@SuppressWarnings("unused")
	public void push(T new_data) {
		Node temp=new Node();
		if(temp==null) {
			System.out.println("\nOverFlow");
			return;
		}
		temp.data=new_data;
		temp.next=top;
		top=temp;

	}

	public boolean isEmpty() {
		return top==null;

	}

	public Object peak() {
		if(!isEmpty()) {
			return top.data;
		}
		else {
			System.out.println("\nStack Underflow");
			return -1;
		}
	}

	public Object pop() {
		if(top==null) {
			System.out.println("Stack is underflow");
			return -1;
		}
		Object data=top.data;
		top=top.next;
		return data;
	}

	public void Display () {
		if(top==null) {
			System.out.println("Stack underFlow");
			System.exit(1);
		}
		else {
			Node temp =top;
			while(temp!=null) {
				System.out.print("=>"+temp.data);;
				temp=temp.next;
			}
			System.out.println();
		}
	}

}
