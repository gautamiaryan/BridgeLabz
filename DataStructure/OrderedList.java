package com.bridgelabz.Program.DataStructure;

import java.util.Scanner;

public class OrderedList<T  extends Comparable<T>> {
	Node head;
	Node tail;
	int size = 0;
	class Node {

		Object data;
		Node next;
		Node prev;

		public Node(Object data) {
			this.data = data;
			this.next = null;
			this.prev =null;
		}

	}

	public void add(T data) {

		Node temp = head;
		Node node = new Node(data);
		size++;
		if (head == null) {
			head = node;
			head.next = tail;
			tail = head;
		} else if (data.compareTo((T) head.data) < 0) {

			node.next = head;
			head = node;
		} else {
			if (data.compareTo((T) tail.data) > 0) {
				tail.next = node;
				tail = node;
				return;
			}
			Node prev = null;
			while (data.compareTo((T) node.data) > 0 && node.next != null) {
				prev = node;
				node = node.next;
			}
			prev.next = node;
			node.next = node;
		}
	}


	public void remove(T item) {
		Node node = head;
		Node prev = null;
		if (head.data.equals(item)) {
			head = head.next;
			size -= 1;
			return;
		} else if (tail.data.equals(item)) {
			while (!node.next.data.equals(tail.data)) {
				node = node.next;
			}
			node.next = null;
			tail = node;
			return;
		} else {
			while (!node.data.equals(item)) {
				prev = node;
				node = node.next;
			}
			node = node.next;
			prev.next = node;
			node = null;
			size -= 1;
		}
	}

	public boolean search(T item) {
		Node node = head;
		while (node != null) {
			if (node.data.equals(item)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public int size() {
		return size;
	}

	public int index(T item) {
		int index = 0;
		Node n = head;
		while (!n.data.equals(item)) {
			n = n.next;
			index++;
		}
		return index;

	}

	public T pop() {
		Node node = head;
		Node prev = null;
		while (node.next != null) {
			prev = node;
			node = node.next;
		}
		prev.next = null;
		tail = prev;
		size -= 1;
		return (T) node.data;
	}

	public T pop(int pos) {
		int index = 0;
		Node prev = null;
		Node node = head;
		if (pos == 0) {
			head = head.next;
			return (T) node.data;
		} else if (pos == size - 1) {
			return pop();
		} else {
			while (index != pos) {
				prev = node;
				node = node.next;
				index++;
			}
			prev.next = node.next;
			size -= 1;
			return (T) node.data;
		}
	}

	public String toString() {

		StringBuffer s = new StringBuffer();
		s.append("[ ");
		Node node = head;
		while (node != null) {
			s.append(node.data);
			node = node.next;
			s.append(" ");

		}
		s.append("]");
		return s.toString();

	}


	public void show() {
		System.out.println(toString());
	}


	public static void main(String[] args) {
		Scanner scanner=new Scanner (System.in);
		OrderedList list =new OrderedList();
		boolean flag=true;
		while(flag)
		{
			System.out.println("1.Add ");
			System.out.println("2.remove");
			System.out.println("3.Search");
			System.out.println("4.isEmpty");
			System.out.println("5.size");
			System.out.println("6.pop position");
			System.out.println("7.pop");
			System.out.println("8.Enter your search iteam ");
			System.out.println("9. show");
			System.out.println("Enter the your choice: ");
			int choice=scanner.nextInt();
			int position;
			String data;
			switch (choice) {
			case 1:
				System.out.println("Enter the data");
				data=scanner.next();
				list.add(data);
				break;
			case 2:
				System.out.println("Enter the data");
				data=scanner.next();
				list.remove(data);
				break;
			case 3:
				System.out.println("Enter the data");
				data=scanner.next();
				list.search(data);
				break;
			case 4:
				System.out.println(list.isEmpty());
				break;
			case 5:
				System.out.println(list.size());
				break;
			case 6:
				System.out.println("Enter the position");
				position=scanner.nextInt();
				System.out.println(list.pop(position));
				break;
			case 7:
				System.out.println(list.pop());
				break;
			case 8:
				System.out.println("Enter the Search item");
				data=scanner.next();
				list.search(data);
			case 9:
				System.out.println("list :------->");
				list.show();
				break;
			case 10:
				System.out.println("enter data");
				data=scanner.next();
				list.index(data);
				break;
			default :
				System.out.println("Invalid Choice");
			}
		}
	}







}