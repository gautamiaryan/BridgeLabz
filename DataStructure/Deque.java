package com.bridgelabz.Program.DataStructure;
import java.util.*;
public class Deque {

	private DoublyLinkedList list;
	public Deque(){
		list=new DoublyLinkedList();
	}
	public void insertLeft(Object x){
		list.insertAtStart(x);

	}
	public void insertRight(Object x){
		list.insertAtEnd(x);
	}
	public Object deleteLeft(){
		return (int)list.removeAtStart();
	}
	public Object deleteRight(){
		return list.removeAtEnd();
	}
	public boolean isQueueEmpty(){
		return list.isEmpty();
	}
	public void displayFromFront(){
		list.display();
	}

	public static void main(String[] args) {
		Deque deque=new Deque();
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter string");
		String string=scanner.nextLine();
		System.out.println("entered string"+string);
		for(int i=0;i<string.length();i++) {
			char ch=string.charAt(i);
			deque.insertLeft(ch);
		}
		System.out.println("deque is");
		deque.displayFromFront();
		String rev="";
		for(int i=0;i<string.length();i++) {
			char ch=(char)deque.deleteRight();
			rev+=ch;
		}
		System.out.println(rev);


		if(string.equals(rev)) {
			System.out.println("true");
		}
	}

}
