package org.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortedSubsequence {

	public void find3Numbers(int arr[]) {
		int n = arr.length;
		int max = n - 1; // Index of maximum element from right side
		int min = 0; // Index of minimum element from left side
		int i;

		// Create an array that will store index of a smaller
		// element on left side. If there is no smaller element
		// on left side, then smaller[i] will be -1.
		int[] smaller = new int[n];
		smaller[0] = -1; // first entry will always be -1
		for (i = 1; i < n; i++) {
			if (arr[i] <= arr[min]) {
				min = i;
				smaller[i] = -1;
			} else
				smaller[i] = min;
		}

		for (i = 0; i < n; i++) {
			System.out.print(smaller[i] + " ");
		}
		System.out.println();

		// Create another array that will store index of a
		// greater element on right side. If there is no greater
		// element on right side, then greater[i] will be -1.
		int[] greater = new int[n];
		greater[n - 1] = -1; // last entry will always be -1
		for (i = n - 2; i >= 0; i--) {
			if (arr[i] >= arr[max]) {
				max = i;
				greater[i] = -1;
			} else
				greater[i] = max;
		}

		// Now find a number which has both a greater number
		// on right side and smaller number on left side
		for (i = 0; i < n; i++) {
			if (smaller[i] != -1 && greater[i] != -1) {
				System.out.print(arr[smaller[i]] + " " + arr[i] + " " + arr[greater[i]]);
				return;
			}
		}

		// If we reach number, then there are no such 3 numbers
		System.out.println("No such triplet found");
		return;
	}

	public void find3NumbersAdjust(int arr[]) {
		int n = arr.length;
		int max = n - 1; // Index of maximum element from right side
		int min = 0; // Index of minimum element from left side
		int i;

		int[] smaller = new int[n];
		for (i = 0; i < n; i++) {
			smaller[i] = findNumberOfSmaller(arr, i);
		}

		int[] greater = new int[n];
		for (i = 0; i < n; i++) {
			greater[i] = findNumberOfGreater(arr, i);
		}

		int res = 0;
		for (i = 0; i < n; i++) {
			if (smaller[i] != 0 && greater[i] != 0) {
				res += smaller[i] * greater[i];
			}
		}

		if (res != 0) {
			System.out.println(res);
			return;
		}

		System.out.println("No such triplet found");
		return;

	}

	public int findNumberOfSmaller(int arr[], int index) {
		int count = 0;
		for (int i = 0; i <= index; i++) {
			if (arr[i] < arr[index]) {
				count++;
			}
		}
		return count;
	}

	public int findNumberOfGreater(int arr[], int index) {
		int count = 0;
		for (int i = arr.length - 1; i > index; i--) {
			if (arr[i] > arr[index]) {
				count++;
			}
		}
		return count;
	}

}