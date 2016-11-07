package org.problems;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));

		// RectanglesOverlapping ro = new RectanglesOverlapping();
		// System.out.println(ro.checkRectanglesOverlapping("1 1 1 1 -1 -1 3
		// 3"));

		// int arr[] = { 5, 2, 3, 4, 1, 6, 7 };
		// SortedSubsequence ss = new SortedSubsequence();
		// ss.find3NumbersAdjust(arr);

		// int arr[] = {15, -2, 2, -8, 1, 7, -1, 3, 0, 1, 2, -4, 5};
		// LargestSubarray ls = new LargestSubarray();
		// System.out.println(ls.maxLenNaive(arr, 7)==ls.maxLenOptimal(arr, 7));
		// System.out.println(ls.maxLen(arr)==ls.maxLenOptimal(arr, 0));

		// BuildBinaryTree tree = new BuildBinaryTree();
		// int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
		// int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
		// Node root = tree.buildTree(in, post, in.length);
		// System.out.println("Preorder of the constructed tree : ");
		// tree.preOrder(root);
		
		int arr[] = {12, 11, 13, 5, 6, 7};
        HeapSort hs = new HeapSort();
        hs.sort(arr);
        System.out.println("Sorted array is");
        hs.printArray(arr);
	}
}
