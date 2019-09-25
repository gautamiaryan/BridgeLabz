package com.bridgeLabz.DataStructure;

import java.util.Scanner;

public class Queue<T> {
    private int [] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;
    
    Queue(int size){
    	arr=new int[size];
    	capacity=size;
    	front=0;
    	rear=-1;
    	count=0;
    }
    public int enqueue(int item) {
    	int data=0;
    	if(isFull()) {
    		System.err.println("OverFlow");
    	}
    	else
    	{
    	data=item;
    	rear =(rear+1)%capacity;
    	arr[rear]=item;
    	count++;
    	}
    	return data;
    }
    public int dequeue() {
    	int data=0;
    	if(isEmpty()) {
    		System.out.println("underFlow");
    	}
    	else {
    	 data=arr[front];
    	front=(front+1)%capacity;
    	count--;
    	}
    	return data;
    }
    public int peek() {
    	if(isEmpty()) {
    		System.out.println("UnderFlow");
    		System.exit(1);
    	}
    	return arr[front];
    }
    public int size() {
    	return count;
    }
    
     public Boolean isEmpty() {
    	 return (size()==0);
     }
	
     public Boolean isFull() {
    	 return (size()==capacity);
     }
     
     
     
     public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.nextLine();
		int length=string.length();
		Queue queue=new Queue(length);
		for(int i=length-1;i>=0;i--) {
			queue.enqueue(string.charAt(i));
		}
		String reverse="";
		for(int i=0;i<length;i++) {
			char ch=(char)queue.dequeue();
			reverse=reverse+ch;
		}
		if(string.equals(reverse)) {
			System.out.println("Pelindrome");
		}
		else {
			System.out.println("Not Pelindrome");
		}
	}
}
