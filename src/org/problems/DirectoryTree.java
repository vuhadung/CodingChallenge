package org.problems;

import java.util.*;

enum State {
	Unvisited, Visited, Visiting
}

public class DirectoryTree {
	String name;
	LinkedList<DirectoryTree> children;
	// DirectoryTree parent;
	// State state;

	DirectoryTree(String name) {
		this.name = name;
		this.children = new LinkedList<DirectoryTree>(); // need to be initiated
		// this.state = State.Unvisited;
	}

	// Pre-order traversal is also DFS
	public static void preOrderTraversal(DirectoryTree root) {
		System.out.print(root.name + " ");
		for (DirectoryTree e : root.children) {
			preOrderTraversal(e);
		}
	}

	public static void postOrderTraversal(DirectoryTree root) {
		for (DirectoryTree e : root.children) {
			postOrderTraversal(e);
		}
		System.out.print(root.name + " ");
	}

	public static void inOrderTraversal(DirectoryTree root) {
		if (root.children.isEmpty())
			System.out.print(root.name + " ");
		else {
			inOrderTraversal(root.children.getFirst());
			System.out.print(root.name + " ");
			for (int i = 1; i < root.children.size(); i++)
				inOrderTraversal(root.children.get(i));
		}
	}

	// BFS
	public static void BreadthFirstSearch(DirectoryTree root) {
		ArrayList<DirectoryTree> queue = new ArrayList<DirectoryTree>();
		queue.add(root);
		while (!queue.isEmpty()) {
			DirectoryTree node = queue.get(0);
			for (DirectoryTree e : node.children)
				queue.add(e);
			System.out.print(node.name + " ");
			queue.remove(0);
		}
	}

	// DFS using stack
	public static void DFS(DirectoryTree root) {
		Stack<DirectoryTree> stack = new Stack<DirectoryTree>();
		stack.push(root);
		while (!stack.isEmpty()) {
			DirectoryTree node = stack.pop();
			System.out.print(node.name + " ");
			if (node.children != null) {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					stack.push(node.children.get(i));
				}
			}
		}
	}

	// findPath using stack
	public static void findPath(DirectoryTree root, DirectoryTree p) {
		Stack<DirectoryTree> stack = new Stack<DirectoryTree>();
		stack.push(root);

		HashMap<String, State> color = new HashMap<String, State>();
		color.put(root.name, State.Unvisited);

		while (!stack.isEmpty()) {
			DirectoryTree node = stack.peek();

			if (color.get(node.name) != State.Visited)
				color.replace(node.name, State.Visiting);

			// Path found
			if (p.name == node.name) {
				for (int i = 0; i < stack.size(); i++)
					if (color.get(stack.get(i).name) != State.Unvisited)
						System.out.print(stack.get(i).name + " ");
				return;
			}

			if (!node.children.isEmpty()) {
				if (State.Visiting == color.get(node.name)) {
					color.replace(node.name, State.Visited);
					for (DirectoryTree e : node.children) {
						color.put(e.name, State.Unvisited);
						stack.push(e);
					}
				} else {
					stack.pop();
				}
			} else
				stack.pop();
		}

	}

	public static void findPathRecursive(DirectoryTree root, DirectoryTree p, LinkedList<DirectoryTree> path) {
		path.add(root);

		// Path found
		if (p.name == root.name) {
			for (DirectoryTree e : path)
				System.out.print(e.name + " ");
			return;
		}

		if (!root.children.isEmpty()) {
			for (DirectoryTree e : root.children)
				findPathRecursive(e, p, path);
			path.remove(root);
		} else
			path.remove(root);
	}

	/*
	 * Some other problems: 1. Find path from root to a node.
	 * 
	 * 2. Find path between two nodes: is path from each node to their first
	 * common ancestor.
	 * 
	 */

}