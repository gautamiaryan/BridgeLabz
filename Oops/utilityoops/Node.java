package com.bridgelabz.utilityoops;


public class Node <T>{
	

	 T data;
	 Node<T> link;
	 public Node()
	 {
		 this.data=null;
		 this.link=null;
	 }
	 public T getData()
	 {
		 return data;
	 }
	 public Node<T> getLink()
	 {
		 return link;
	 }

}
