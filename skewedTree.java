package com.greatlearning.BST;

class Node
{
	int val;
	Node left, right;
	Node(int item)
	{
		val = item;
		left = right = null;
	}
}

class skewedTree
{
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;
	static void skewTree(Node root, int order)
	{
		if(root == null)
		{
			return;
		}
		if(order > 0)
		{
			skewTree(root.right, order);
		}
		else
		{
			skewTree(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;
		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		if (order > 0)
		{
			skewTree(leftNode, order);
		}
		else
		{
			skewTree(rightNode, order);
		}
	}
	
	static void rightSkew(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		rightSkew(root.right);	
	}
	
	public static void main (String[] args)
	{
		node = new Node(50);
		node.left = new Node(30);
		node.right = new Node(60);
		node.left.left = new Node(10);
		node.right.left= new Node(55);
		int order = 0;
		skewTree(node, order);
		rightSkew(headNode);
	}
}
