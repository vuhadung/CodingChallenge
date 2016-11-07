package org.problems;

import java.util.HashMap;

public class LargestSubarray {
	public int maxLen(int arr[]) {
		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int sum = 0; // Initialize sum of elements
		int max_len = 0; // Initialize result

		// Traverse through the given array
		for (int i = 0; i < arr.length; i++) {
			// Add current element to sum
			sum += arr[i];

			if (arr[i] == 0 && max_len == 0)
				max_len = 1;

			if (sum == 0)
				max_len = i + 1;

			// Look this sum in hash table
			Integer prev_i = hM.get(sum);

			// If this sum is seen before, then update max_len
			// if required
			if (prev_i != null)
				max_len = Math.max(max_len, i - prev_i);
			else // Else put this sum in hash table
				hM.put(sum, i);
		}

		return max_len;
	}

	public int maxLenNaive(int arr[], int k) {
		int n = arr.length;
		int max_len = 0;
		for (int i = 0; i < n; i++) {
			// Initialize currr_sum for every starting point
			int curr_sum = 0;

			// try all sub-arrays starting with 'i'
			for (int j = i; j < n; j++) {
				curr_sum += arr[j];
				if (curr_sum == k)
					max_len = Math.max(max_len, j - i + 1);
			}
		}
		return max_len;

	}

	public int maxLenOptimal(int arr[], int k) {
		int sum = 0; // Initialize sum of elements
		int max_len = 0; // Initialize result
		HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			Integer prev_i = dict.get(sum - k);
			if (prev_i != null)
				max_len = Math.max(max_len, i - prev_i);
			else
				dict.put(sum, i);
		}
		return max_len;
	}
}
