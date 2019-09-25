package com.bridgeLabz.DataStructure;

public class PrimeNumber2DArray {
	
	public static boolean isPrime(int number){
        int count=0;
        if(number<2) {
        	return false;
        }
        for(int i=2;i<=number/2;i++){
            if(number%i==0){
            count+=1;
            }
        }
        if(count==0){
            return true;
        }
        else{
        	return false;
        }
    }
	
	public static void main(String[] args) {
		int [][] listPrimes=new int [10][100];
		int n=0;
	    for(int i=0;i<10;i++) {
			for(int j=0;j<100;j++) {
				if(isPrime(++n)){
					listPrimes[i][j]=n;
					}
				}
				
			}
	    int count=0;int count1=100;
			for (int i = 0; i < 10; i++) {
				System.out.print(count+"-"+count1+":");
				for (int j = 0; j < 100; j++) {
					count+=1;count1+=1;
					if(listPrimes[i][j]==0) {
						System.out.print("");
					}else {
					System.out.print(listPrimes[i][j]+" ");
					}
				}
				System.out.println("");
			}
	}
}
