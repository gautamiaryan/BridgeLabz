package com.bridgelabz.Program.DataStructure;

import java.util.Scanner;

public class BalancedParentheses {

	public static Boolean checkBalancedParentesis(String expression){
		if (expression.isEmpty()) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < expression.length(); i++){
			char current = expression.charAt(i);
			if (current == '{' || current == '(' || current == '['){
				stack.push(current);
			}
			if (current == '}' || current == ')' || current == ']'){
				if (stack.isEmpty()) {
					return false;
				}
				char last = (char) stack.peek();
				if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[') {
					stack.pop();
				}
				else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Stack<String> stack=new Stack<String>();
		System.out.println("Enter the expression");
		String expression=scanner.nextLine();
		Boolean result=checkBalancedParentesis(expression);
		System.out.println(result);
	}


}
