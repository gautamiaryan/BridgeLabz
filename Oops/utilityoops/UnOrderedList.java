package com.bridgelabz.utilityoops;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;


public class UnOrderedList <T>{
	
	private Node<T> start;
	private Node<T> end;
	private Node<T> next;
	int listSize = 0;
	public static final Logger LOGGER = Logger.getLogger(UnOrderedList.class.getName());
	public Node<T> getHead()
	{
		return start;
	}
	
	public UnOrderedList() {
		this.start = null;
		this.end = null;
	}

	public static final String filePath="/home/gautam/Documents/text.txt";
	@SuppressWarnings("unchecked")
	public void readFile(){
		
		try (FileReader fr = new FileReader(filePath);
				BufferedReader br = new BufferedReader(fr)) {
			     
			for (String s; (s = br.readLine()) != null; ) {
				String[] sarr = s.split(",");
				for (int i = 1; i < sarr.length; i++) {
					@SuppressWarnings("rawtypes")
					Node node = new Node();
					node.data = sarr[i];
					listSize++;
					if (start == null) {
						end = node;
						start = node;
					} else {
						end.link = node;
						end = node;
					}
				}
			}
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}
		 catch(NullPointerException e) {
			 e.printStackTrace();
		 }

	}
	public void writeIntoFile() {
		try (FileWriter fw = new FileWriter("/home/gautam/Documents/text.txt")) {
			next = start;
			while (next != null) {
				fw.write(next.data.toString());
				if (next.link != null) {
					fw.write(",");
				}
				next = next.link;
				fw.flush();
				display();
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		
	}
	
	public void add(T item) {
		boolean b=search(item);
		if(!b) {
		Node<T> node = new Node<>();
		node.data = item;
		if (start== null) {
			end = node;
			start = node;
		} else {
			end.link = node;
			end = node;
		}
		listSize++;
		}
		else
		{
			LOGGER.info("allready exist");
		}
	}

	public boolean remove(T item) {
		Node<T> temp;
		if (start.data.equals(item)) {
			start = start.link;
			listSize--;
			return true;
		} else {
			next = start;
			while (next.link!= null) {
				if(next.link.link==null)
				{
					break;
				}
				if (next.link.data.equals(item)) {
					temp = next.link;
					next.link = temp.link;
					temp = null;
					listSize--;
					return true;
				}
				next = next.link;
			}

			if ( next.link!=null && next.link.data.equals(item)) {

				next.link = null;
				end = next;
				listSize--;
				return true;
			} else {
				return false;
			}
		}
		
	}

	public boolean search(T item) {
		next = start;
		while (next != null) {
			if (next.data == item) {
				return true;
			}
			next=next.link;
		}
		return false;
	}

	public boolean isEmpty() {
		if (start.data != null) {
			return false;
		}
		return true;
	}

	public int size() {
		return listSize;
	}
	
	public int index(T item)
	{
		next=start;
		int index=0;
		while(next!=null)
		{
			if (next.data == item) {
				return index;
			}
			next=next.link;
			index++;
		}
		return -1;
	}
	
	public void insert(int pos,T item)
	{
		
		if(pos==1)
		{
			Node<T> node=new Node<>();
			node.data=item;
			node.link=start;
			start=node;
			return;
		}
		next=start;
		for (int i = 0; i < pos-2; i++) 
		{
			next=next.link;
			if(next==null)
			{
				LOGGER.info("there is less item then position");
				return;
			}
		}
		Node<T> node=new Node<>();
		node.data=item;
		node.link=next.link;
		next.link=node;
	}
	public void display()
	{
		next=start;
		while(next!=null)
		{
			System.out.println(next.data);
			next=next.link;
		}
	}
	public T pop()
	{
		T temp=null;
		if(start.link==null)
		{
			temp=start.data;
			start=start.link;
			return temp;
		}
		next=start;
		while(next.link.link!=null)
		{
			next=next.link;
		}
		temp=next.link.data;
		next.link=null;
		end=next;
		return temp;
	}
	
	public T pop(int pos)
	{
		if(pos>=1 && pos<=listSize)
		{
		T temp=null;
		if(pos==1)
		{
			temp=start.data;
			start=start.link;
			return temp;
		}
		next=start;
		for (int i = 0; i < pos-2; i++) 
		{
			next=next.link;
		}
		temp=next.link.data;
		if(next.link.link==null)
		{
			end=next;
		}
		next.link=next.link.link;
		
		return temp;
		}
		else {
			LOGGER.info("invalid possiton");
			return null;
		}
	}
	public void append(T item)
	{
		Node<T> node = new Node<>();
		node.data = item;
		if (start.data == null) {
			end = node;
			start = node;
		} else {
			end.link = node;
			end = node;
		}
		listSize++;
	}	

	
	public static void main(String[] args) {
		UnOrderedList<Integer> list=new UnOrderedList<Integer>();
		Scanner scn=new Scanner(System.in);
		boolean b=true;
		while(b) {
			System.out.println("Enter your choice \n1.readfile\n2.writeIntoFile\n3.add\n4.remove\n5.search\n"
					+ "6.isEmpty\n7.size\n8.index\n9.insert\n10.display\n11.pop\n12.pop at pos\n13.append");
			int choice=scn.nextInt();
			int item;
			
			switch(choice) {
			
			case 1:{
				System.out.println("reading frpm file");
				list.readFile();
				break;
				
			}
			case 2:{
				System.out.println("Writing into file");
				list.writeIntoFile();
				break;
				
			}
			case 3:{
				System.out.println("enter item");
				item=scn.nextInt();
				list.add(item);
				break;
			}
			case 4:{
				System.out.println("Remove item");
				item=scn.nextInt();
				list.remove(item);
				break;
			}
			case 5:{
				System.out.println("enter to search");
				item=scn.nextInt();
				list.search(item);
				break;
				
			}
			case 6:{
				System.out.println("is Empty");
				list.isEmpty();
				break;
				
			}
			case 7:{
				System.out.println("size?");
				list.size();
				break;
				
			}
			case 8:{
				System.out.println("index?");
				item=scn.nextInt();
				list.index(item);
				break;
				
			}
			case 9:{
				System.out.println("inserted");
				item=scn.nextInt();
				int pos=scn.nextInt();
				list.insert(pos, item);
				break;
				
			}
			case 10:{
				System.out.println("display");
				list.display();
				break;
			}
			case 11:{
				System.out.println("poped item");
				list.pop();
				break;
			}
			case 12:{
				System.out.println("popped at pos");
				int pos=scn.nextInt();
				list.pop(pos);
				break;
			}
			case 13:{
				System.out.println("Appended");
				item=scn.nextInt();
				list.append(item);
				break;
				
			}
			default:{
				b=false;
				break;
			}
			}
		}
	}
	
}
