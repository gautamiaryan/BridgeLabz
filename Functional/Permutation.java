package com.bridgeLabz.Functional;
import java.util.*;
public class Permutation {
   public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the String");
        String string=scanner.nextLine();
        permutationOfString(string.toCharArray(),0);
    }
    
    private static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
   
    private static void permutationOfString(char[] ch, int currentIndex) {
        if (currentIndex == ch.length - 1) {
            System.out.println(String.valueOf(ch));
        }

        for (int i = currentIndex; i < ch.length; i++) {
            swap(ch, currentIndex, i);
            permutationOfString(ch, currentIndex + 1);
            swap(ch, currentIndex, i);
        }
    }
}
