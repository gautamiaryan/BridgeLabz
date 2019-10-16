package com.bridgelabz.utilityoops;

public class SinglyLinkedList<T> {
	
	class Node <T>{
		private T data;
		private Node<T> next;
		public Node(){
			this.data=null;
		    this.next=null;
		}

		public Node(T data){
			this.data=data;
			this.next=null;
		}
		public void setData(T d){
			this.data=d;
		}
		public void setNext(Node<T> n){
			this.next=n;
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
		return (head==null);
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
	public void append(T new_data){
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
			append(new_node);
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
	public void remove()
	{
		if(head==null)
			System.out.println("List is already Empty !!");
		else {
			head=head.getNext();
			size--;
		}
	}
	public void pop()
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

	
	
	

}
