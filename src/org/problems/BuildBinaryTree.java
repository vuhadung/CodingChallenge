package org.problems;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BuildBinaryTree {
	
	int pIndex;

	/*
	 * Recursive function to construct binary of size n from In-order traversal
	 * in[] and Post-order traversal post[]. Initial values of inStrt and inEnd
	 * should be 0 and n -1. The function doesn't do any error checking for
	 * cases where in-order and post-order do not form a tree
	 */
	Node buildUtil(int in[], int post[], int inStrt, int inEnd) {

		if (inStrt > inEnd)
			return null;

		Node node = new Node(post[this.pIndex]);
		this.pIndex--;

		/* If this node has no children then return */
		if (inStrt == inEnd)
			return node;

		/*
		 * Else find the index of this node in Inorder traversal
		 */
		int iIndex = search(in, inStrt, inEnd, node.data);

		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		node.right = buildUtil(in, post, iIndex + 1, inEnd);
		node.left = buildUtil(in, post, inStrt, iIndex - 1);

		return node;
	}

	// This function mainly initializes index of root
	// and calls buildUtil()
	Node buildTree(int in[], int post[], int n) {
		this.pIndex = n - 1;
		return buildUtil(in, post, 0, n - 1);
	}

	/*
	 * Function to find index of value in arr[start...end] The function assumes
	 * that value is postsent in in[]
	 */
	int search(int arr[], int strt, int end, int value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				break;
		}
		return i;
	}

	/* This funtcion is here just to test */
	void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
}