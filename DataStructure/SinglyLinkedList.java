package com.bridgeLabz.DataStructure;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SinglyLinkedList<T>{
	class Node{
		private T data;
		private Node next;
		public Node(){
			data=null;
			Node next;
		}

		public Node(T data){
			this.data=data;
		}
		public void setData(T d){
			data=d;
		}
		public void setNext(Node n){
			next=n;
		}
		public T getData(){
			return (data);
		}
		public Node getNext(){
			return (next);
		}
	}

	private int size;
	private Node head;
	public SinglyLinkedList(){
		size=0;
		head=null;
	}
	public boolean isEmpty(){
		if(head==null)
		{
			return true;
		}
		return false;
	}
	public int getListSize(){
		return (size);
	}

	public void ViewList(){
		System.out.println("data is ");
		Node temp;
		if(isEmpty()){
			System.out.println("List is empty");
		}else {
			temp=head;
			for (int i = 1; i <= size; i++){
				System.out.println(" "+temp.getData());
				temp=temp.getNext();
			}
		}
	}
	public void add(T new_data){
		Node n=new Node(new_data);
		n.setNext(head);
		head=n;
		size++;
	}
	public void insertAtLast(T new_data){
		Node temp;
		Node newValue=new Node();
		newValue.setData(new_data);
		temp=head;
		if(temp==null)
		{
			head=newValue;
		}else {
			while(temp.getNext() !=null)
				temp=temp.getNext();
			temp.setNext(newValue);
		}
		size++;
	}

	public void insert(T new_node, int position){
		if(position==1){
			add(new_node);
		}
		else if(position==size-1){
			insertAtLast(new_node);
		}
		else if(position>1 && position<=size){
			Node newValue=new Node(new_node);
			Node temp=head;
			for (int i = 0; i < position-1; i++)
			{
				temp=temp.getNext();
				newValue.setNext(temp.getNext());
				temp.setData(new_node);
			}
			size++;
		}else {
			System.out.println("Insertion is not possible at the position of "+position );
		}
	}
	public void deleteAtFirst()
	{
		if(head==null)
			System.out.println("List is already Empty !!");
		else {
			head=head.getNext();
			size--;
		}
	}
	public void deleteAtLast()
	{
		if(head==null)
		{
			System.out.println("List is already Empty !!");
		}else if(size==1) {
			head=null;
			size--;
		}else {
			Node temp=head;
			while(temp.next.next!=null)
			{
				temp=temp.getNext();

			}
			temp.setNext(null);
			size--;
		}
	}
	public void pop(int position)
	{
		if(head==null)
		{
			System.out.println("List is already Empty");
		}else if(size==1){
			head=null;
			size--;
		}else {
			Node temp=head;
			Node temp1;
			for (int i = 0; i < position-1; i++)
			{
				temp=temp.getNext();
				temp1=temp.getNext();
				temp.setNext(temp.getNext());
				size--;
			}
		}
	}
	public boolean search(T data)
	{
		Node temp=head;
		while(temp!=null)
		{
			if(temp.data.equals(data))
				return true;
			else
				temp=temp.getNext();
		}
		return false;
	}
	public static void main(String[] args)throws Exception
	{
		
		Scanner scanner=new Scanner (System.in);
		SinglyLinkedList<String> list =new SinglyLinkedList<>();
		boolean flag=true;
		while(flag)
		{
			System.out.println("1.Add iteam to the list at first ");
			System.out.println("2.Add iteam to the list at last ");
			System.out.println("3.Add iteam to the list at specified position");
			System.out.println("4.delete first iteam to the list");
			System.out.println("5.delete last itaem to the list");
			System.out.println("6.delete iteam to the list at specified position");
			System.out.println("7.view list");
			System.out.println("8.Enter your search iteam ");
			System.out.println("9. Exit");
			System.out.println("Enter the your choice: ");
			int choice=scanner.nextInt();
			int position;
			String data;
			switch (choice) {
			case 1:
				System.out.println("Enter the value of list iteam");
				data=scanner.next();
				list.add(data);
				break;
			case 2:
				System.out.println("Enter the value of list iteam");
				data=scanner.next();
				list.insertAtLast(data);
				break;
			case 3:
				System.out.println("Enter the position");
				position=scanner.nextInt();
				System.out.println("Enter the value of list iteam");
				data=scanner.next();
				list.insert(data, position);
			case 4:
				list.deleteAtFirst();
				break;
			case 5:
				list.deleteAtLast();
				break;
			case 6:
				System.out.println("Enter the position");
				position=scanner.nextInt();
				list.pop(position);
				break;
			case 7:
				list.ViewList();
				break;
			case 8:
				System.out.println("Enter the Search item");
				data=scanner.next();
				list.search(data);
			case 9:
				flag=false;
			case 10:
			default :
				System.out.println("Invalid Choice");
			}
		}
	}
}
