/*
 * Author : Soukarya Datta
 * JDK    : Java 17
 * Version: 1.0.2
 * Date   : May 1, 2022
 * 
 */

package com.greatlearning.dsa.lab3.q2.main;

import java.util.List;
import java.util.Scanner;

import com.greatlearning.dsa.lab3.q2.main.BstCreation.Node;

public class Main {

	private static String findPairSum(List<Integer> list,Node root, int sum) {
		
		BstCreation.inOrderTraversal(root, sum);
		
		int left=0,right=list.size()-1;
		
		while(left<right) {
			if(list.get(left)+list.get(right) == sum) {
				return "\nPair is ("+list.get(left)+","+list.get(right)+")";
			} else if(list.get(left)+list.get(right) < sum) {
				left++;
			} else {
				right++;
			}
		}
		return "\nnodes are not found.";
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int value, num, sum=0;
		System.out.println("Enter total no of values: ");
		num = sc.nextInt();
		Node root = null;
		Node result = null;
		for (int i = 0; i < num; i++) {
			System.out.print("Insert value at " + (i + 1) + ": ");
			value = sc.nextInt();
			if (root == null) {
				root = BstCreation.insert(root, value);
			} else {
				result = BstCreation.insert(root, value);
				if (result.getKey() == value)
					i -= 1;
			}
		}
		System.out.print("Sum=");
		sum = sc.nextInt();
		
		System.out.println(Main.findPairSum(BstCreation.getList(), root, sum));
		
		// Resource de-allocation
		sc.close();
		
		System.out.println("\n*****\tProgram completed successfully\t*****");
	}

}
