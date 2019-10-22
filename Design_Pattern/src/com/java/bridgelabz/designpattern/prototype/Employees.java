package com.java.bridgelabz.designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{
	
	private List<String> empList;
	
	public Employees() {
		this.empList=new ArrayList<String>();
	}
	
	
	public  Employees(List<String> list){
		this.empList=list;
	}
     
	public List<String> getEmpList() {
		return empList;
	}



	public void loadData(){
		
		empList.add("Raj Krishna Jha");
		empList.add("Gautam Singh");
		empList.add("Amrita Singh");
		empList.add("Gaurav Chowdhary");
		empList.add("Tushar dev");
		empList.add("Shubham kumar");
		empList.add("Kumar Anand");
		empList.add("Abhishek Anand");
	}
	
	public Object clone() throws CloneNotSupportedException{
		List<String> temp = new ArrayList<String>();
		for(String s : this.getEmpList()){
			temp.add(s);
		}
		return new Employees(temp);
}
	
	
	
	
	

 	
	

}
