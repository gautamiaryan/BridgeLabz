package com.bridgelabz.Program.DataStructure;

public class Calender {
	
	public static int day(int month, int day, int year)
	{
		int y = year - (14 - month) / 12;
		int x = y + y/4 - y/100 + y/400;
		int m = month + 12 * ((14 - month) / 12) - 2;
		int d = (day + x + (31*m)/12) % 7;
		return d;
	}


	public static boolean isLeapYear(int year)
	{
		if  ((year % 4 == 0 && year % 100 != 0)|| (year % 400 == 0)) {
			
			return true;
		}
		else {
			
			return false;
		}

	}

	public static void main(String[] args)
	{
		int month = Integer.parseInt(args[0]);    
		int year = Integer.parseInt(args[1]);    

		String[] months= {"" , "january", "February", "March", "April",
				"May", "June", "July", "August", "September", "October", "November", "December"};
		int [] days= {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		if(month==2 && isLeapYear(year))
		{
			days[month]=29;
		}
		System.out.println("   " + months[month] + " " + year);
		System.out.println("Su Mo Tu We Th Fr Sa");

       
        int d = day(month, 1, year);
        int arr[][]=new int [6][7];
        int count=1,k=0;
        
        for(int i=0;i<6;i++) {
        	for(int j=0;j<7;j++) {
        		while(k != d)
        		{
        			arr[i][j]=0;
        			k++;j++;
        		}
        		if(count != days[month]+1) {
        			arr[i][j]=count++;
        		  }
        		else {
        			arr[i][j]=0;
        		}
        	}
        }
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <7; j++) {
            	if(arr[i][j]==0) {
            		System.out.print(" "+"  ");
            	}
            	else if(arr[i][j]<10){
            		System.out.print("0"+arr[i][j]+" ");
            	}
            	else {
        	        System.out.print(arr[i][j]+" ");
            	}
        	   
        	}
            System.out.println();
        }
        }
       

}
