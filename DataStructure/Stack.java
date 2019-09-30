package com.bridgelabz.Program.DataStructure;

import java.util.Scanner;

@SuppressWarnings("unused")
public class Stack<T> {

	Object [] element;
	int capecity =10;
	int top;

	Stack(){
		element=new Object[10];
		top=-1;
	}

	public boolean push(Object object){
		if(top==capecity-1)
		{
			System.out.println("Stack is OverFlow");
			return false;
		}
		element[++top]=object;
		return true;
	}

	public Object pop(){
		if(top==-1){
			System.out.println("Stack is underFlow");
			return null;
		}
		return element[top--];
	}
	public Object peek(){
		if(top==-1)
		{
			System.out.println("Stack is undaerFlow");
			return null;
		}
		return element[top];
	}

	public int size(){
		return top+1;
	}

	public boolean isEmpty(){
		return top==-1;
	}

	public String toString(){
		String st="[";
		for (int i = 0; i <= top; i++)
		{
			st=st+element[i];
			if(i<top)
				st=st+",";
		}
		return st+"]";
	}

	public void display()
	{ 
		if(!isEmpty())
		{
			int temp =top;
			while(temp!=-1)
			{	System.out.println(element[temp]);
			temp--;}
		}
	}

}