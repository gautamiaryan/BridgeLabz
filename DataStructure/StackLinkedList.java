package com.bridgelabz.Program.DataStructure;

import java.util.Scanner;

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

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		StackLinkedList<String> stack=new StackLinkedList<String>();
		boolean flag=true;
		while(flag)
		{
			System.out.println("1.Push ");
			System.out.println("2.IsEmpty");
			System.out.println("3.Pop");
			System.out.println("4.Peak");
			System.out.println("5.Display");
			System.out.println("6. Exit");
			System.out.println("Enter the your choice: ");
			int choice=scanner.nextInt();
			int position;
			String data;
			switch (choice) {
			case 1:
				System.out.println("Enter the value of list iteam");
				data=scanner.next();
				stack.push(data);
				break;
			case 2:
				boolean result=stack.isEmpty();
				System.out.println(result);
				break;
			case 3:
				Object dataPoped=stack.pop();
				System.out.println(dataPoped);
				break;
			case 4:
				Object res=stack.peak();
				System.out.println(res);
				break;
			case 5:
				stack.Display();
				break;
			case 6:
				flag=false;
			default :
				System.out.println("Invalid Choice");
			}
		}

	}

}
