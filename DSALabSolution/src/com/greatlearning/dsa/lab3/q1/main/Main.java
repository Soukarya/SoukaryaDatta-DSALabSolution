/* 
 * Author : Soukarya Datta
 * JDK    : Java 17
 * Version: 1.0.1
 * Date   : May 1, 2022
 * 
 */

package com.greatlearning.dsa.lab3.q1.main;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	/*
	 * 
	 * () -> Parenthesis 
	 * {} -> Curly brackets 
	 * [] -> Square Brackets 
	 * <> -> Angle brackets
	 * 
	 */
	private static boolean check(String input, int lengthOfInput) {

		Stack<Character> s = new Stack<>();
		char ch = ' ';
		char check = ' ';
		boolean areBracketsBalanced = false;
		String regex = "^[\\(\\)\\{\\}\\<\\>\\[\\]]*$";

		if(input.matches(regex)) {
			if (lengthOfInput % 2 == 0) {
				for (int i = 0; i < lengthOfInput; i++) {
					ch = input.charAt(i);
					if (ch == '(' || ch == '{' || ch == '[' || ch == '<') {
						s.push(input.charAt(i));
						continue;
					}

					if (s.isEmpty()) {
						return areBracketsBalanced;
					} else {
						switch (ch) {
							case ')':
								check = s.pop();
								if (check == '(') {
									areBracketsBalanced = true;
								}
								break;
							case '}':
								check = s.pop();
								if (check == '{') {
									areBracketsBalanced = true;
								}
								break;
							case ']':
								check = s.pop();
								if (check == '[') {
									areBracketsBalanced = true;
								}
								break;
							case '>':
								check = s.pop();
								if (check == '<') {
									areBracketsBalanced = true;
								}
								break;
						}
					}
				}
			}
		} else {
			throw new RuntimeException("Invalid input!!! Please enter only brackets- (), {}, [] and/or <>");
		}
		
		s = null;
		return areBracketsBalanced;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string which will contain only brackets- (), {}, [], and/or <>:");
		String input = sc.next();
		int lengthOfInput = input.length();

		if (lengthOfInput > 0) {
			try {
				if (check(input, lengthOfInput)) {
					System.out.println("\nThe entered Strings has Balanced Brackets");
				} else {
					System.out.println("\nThe entered Strings do not contain Balanced Brackets");
				}
			} catch(RuntimeException e) {
				System.err.println("\n"+e.getMessage());
			}
		} else {
			System.err.println("\nYou entered an empty string!!! Thank you");
		}

		// Resource de-allocation
		sc.close();
	}

}
