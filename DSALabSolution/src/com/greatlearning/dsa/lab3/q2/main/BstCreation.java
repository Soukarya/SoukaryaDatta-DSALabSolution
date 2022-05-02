package com.greatlearning.dsa.lab3.q2.main;

import java.util.ArrayList;
import java.util.List;

public class BstCreation {
	
	private static List<Integer> list = new ArrayList<>();
	
	public static List<Integer> getList(){
		return list;
	}
	
	// BST node
	static class Node {
		private int key;
		private Node left, right;
		
		public int getKey() {
			return key;
		}
	};

	// creation of new node
	static Node newNode(int data) {
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	static Node insert(Node root, int key) {
		Node newnode = newNode(key);
		Node x = root;
		Node y = null; // y maintains pointer to x
		while (x != null) {
			y = x;
			if (key < x.key)
				x = x.left;
			else if (key > x.key)
				x = x.right;
			else {
				return newnode;
			}
		}
		// If the root is null, the tree is empty.
		if (y == null)
			y = newnode;
		
		// assign new node node to the left child
		else if (key < y.key)
			y.left = newnode;
		
		// assign the new node to the right child
		else
			y.right = newnode;
		
		// return pointer to new node
		return y;
	}

	public static void inOrderTraversal(Node root, int sum) {

		// left root right
		if (root == null) {
			return;
		}else {
			inOrderTraversal(root.left, sum);
			list.add(root.key);
			inOrderTraversal(root.right, sum);
		}
	}
}