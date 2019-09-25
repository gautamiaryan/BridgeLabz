package com.bridgeLabz.DataStructure;
public class DoublyLinkedList<T> {
	class Node{
		protected Object data;
		protected Node next;
		protected Node prev;
		public Node() {
			next=null;
			prev=null;
			data=0;
		}
		public Node(Object dta,Node nxt,Node prv) {
			data=dta;
			next=nxt;
			prev=prv;
		}
		
		public void setLinkNext(Node nxt) {
			next=nxt;
		}
		public void setLinkPrev(Node prv) {
			prev=prv;
		}
		public Node getLinkNext() {
			return next;
		}
		public Node getLinkPrev(){
	        return prev;
	    }
	    
	    public void setData(Object new_data){
	        data = new_data;
	    }
	    public Object getData(){
	        return data;
	    }
	}
    protected Node start;
    protected Node end;
    protected int size;
    
    public DoublyLinkedList() {
    	start=null;
    	end=null;
    	size=0;
    }
    
    public boolean isEmpty() {
    	return start==null;
    }
	
    public int getSize() {
    	return size;
    }
    
    public Object insertAtStart(Object new_data) {
    	Node node = new Node(new_data,null,null);
    	if(start==null) {
    		start=node;
    		end=start;
    	}
    	else {
    		start.setLinkPrev(node);
    		node.setLinkNext(start);
    		start=node;
    	}
    	size++;
    	
    	return new_data;
    }
    
    public Object insertAtEnd(Object new_data) {
    	Node node=new Node(new_data,null,null);
    	if(start==null) {
    		start=node;
    		end=start;
    	}
    	else {
    		node.setLinkPrev(end);
    		end.setLinkNext(node);
    		end=node;
    	}
    	size++;
    	
    	return new_data;
    }
    
    public Object insertAtPosition(Object new_data,int position) {
    	Node node=new Node(new_data,null,null);
    	if(position==1) {
    		insertAtStart(new_data);
    		return 0;
    	}
    	Node temp=start;
    	for(int i=2;i<=size;i++) {
    		if(i==position) {
    			
    		}
    	}
    	return new_data;
    }
    
    public Object removeAtStart() {
    	if(start==null) {
    		System.out.println("List is Empty");
    		return 0;
    	}
    	start = start.getLinkNext();
        start.setLinkPrev(null);
        size--;
        return start;
    }
    
    public Object removeAtEnd() {
    	if(start==null) {
    		System.out.println("Empty list");
    		return 0;
    	}
    	else {
    		Node temp=start;
    		while(temp.getLinkNext()!=null) {
    			temp=temp.getLinkNext();
    		}
    		Object node=temp.getData();
    		if(temp.getLinkPrev()!=null) {
    			temp.getLinkPrev().next=null;
    		}
    		else
    		{
    			start=null;
    		}
    		return node;
    	}
    }
    public Object deleteAtPosition(int position)
    {        
        if (position == 1) 
        {
            if (size == 1)
            {
                start = null;
                end = null;
                size = 0;
                return 0; 
            }
            start = start.getLinkNext();
            start.setLinkPrev(null);
            size--; 
            return 0;
        }
        if (position == size)
        {
            end = end.getLinkPrev();
            end.setLinkNext(null);
            size-- ;
        }
        Node ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == position)
            {
                Node p = ptr.getLinkPrev();
                Node n = ptr.getLinkNext();
 
                p.setLinkNext(n);
                n.setLinkPrev(p);
                size-- ;
                return 0;
            }
            ptr = ptr.getLinkNext();
        }  
        return ptr;
    }    
 
    
    public void display()
    {
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLinkNext() == null) 
        {
            System.out.println(start.getData()+" ");
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ " ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null)
        {
            System.out.print(ptr.getData()+ " ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }
    
    public static void main(String[] args) {
		DoublyLinkedList list=new DoublyLinkedList();
		String string="Madam";
		for(int i=0;i<string.length();i++) {
			char ch=string.charAt(i);
			
			list.insertAtEnd(ch);
		}
		list.removeAtStart();
	
		list.display();
	}
     
}
