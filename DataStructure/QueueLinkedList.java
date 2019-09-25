package com.bridgeLabz.DataStructure;
import java.util.*;
class Node {
	int data;
	Node next;
}
public class QueueLinkedList<T> {
	private Node front;
	private Node rear;

	
	QueueLinkedList(){
		this.front =null;
		this.rear =null;
	}


	public void enQueue(int data){
		Node node = new Node();
		node.data = data;
		if(rear ==null){
			rear = front = node;
		}
		else{
			rear.next = node;
			rear = node;
		}
	}


	
	public int deQueue(){
		if(front==null)
			return 0;
		int data = front.data;
		if(front ==rear) {
			rear = front = null;
		}
		else {
			front = front.next;
		}
		return data;
	}


	
	public void display(){  
		if(!isEmpty()){
			Node temp = front;
			while(temp!=rear){
				System.out.print(temp.data+" ");
				temp = temp.next;
			}System.out.print(temp.data+" ");
		}
	}

	

	public boolean isEmpty(){
		return front==null;
	}


	
	public void sort(){
		Node temp =front;
		Node index = null;
		int tempdata;
		while(temp!=null){
			index = temp.next;
			while(index !=null){
				if(temp.data>index.data){
					tempdata = temp.data;
					temp.data = index.data;
					index.data = tempdata;  
				}
				index = index.next;
			}
			temp = temp.next;
		}  
	}
	
	

	public QueueLinkedList removeDuplicate(){
		QueueLinkedList queue = new QueueLinkedList();

		Node temp = front;
		Node index = null;
		while(temp!=null){
			index = temp.next;
			while(index!=null)
			{
				if(index.data==temp.data)
				{
					temp = temp.next;  
				}index = index.next;
			}
			queue.enQueue(temp.data);
			temp=temp.next;

		}
		return queue;
	}

	

	public boolean isAnagram(String str1,String str2){
		if(str1.length() != str2.length()){
			return false;
		}

		char str3 [] =str1.toLowerCase().toCharArray();
		char str4 [] =str2.toLowerCase().toCharArray();

		Arrays.sort(str3);
		Arrays.sort(str4);

		return Arrays.equals(str3, str4);
	}



	public boolean isPrime(int n){
		for(int i=2;i<n;i++){
			if(n%i == 0)
				return false;
		}
		return true;
	}
	
	
	public static void main(String [] arr) {
		int n=2;
		System.out.println(n);
	}
}