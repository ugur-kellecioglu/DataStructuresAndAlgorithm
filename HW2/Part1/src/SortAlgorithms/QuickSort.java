package SortAlgorithms;

import Models.CustomClass;
//-----------------------------------------------------
//Title: QUick sort 
//Author: Uğur Kellecioğlu
//ID: ***
//Section: 1
//Assignment: 1
//Description: Quick Sort implementation
//-----------------------------------------------------
public class QuickSort {

	public static void sort(Comparable[] a, int choose) {
		// --------------------------------------------------------
		// Summary: This method is the public method that calls our actual sort private method
		// Precondition: a is an comparable array that we are going to sort, choose is an integer that represent
		// 				whether array will be sorted ascending or descending  
		// Postcondition: private sort method will be called
		// --------------------------------------------------------
		sort(a, 0, a.length - 1, choose);
	}

	private static void sort(Comparable[] a, int lo, int hi, int choose) {
		// --------------------------------------------------------
		// Summary: This method will called recursively and sort the array
		// Precondition: a is an comparable array that we are going to sort, lo is left pointer hi is the right 
		// 				pointer, choose is user choice for sorting descending or ascending
		// Postcondition: partition method will be called and it will call itself recursively.
		// --------------------------------------------------------
		if (hi <= lo) // if left and right point crossed or left one is bigger the right one
			return;
		
		int j = 0;
		
		if (choose == 0)
			j = partition(a, lo, hi); // Partition (see page 291).
		else if (choose == 1)
			j = partitionReverse(a, lo, hi);
		
		sort(a, lo, j - 1, choose); // Sort left part a[lo .. j-1].
		
		sort(a, j + 1, hi, choose);// Sort right part a[j+1 .. hi].
		
	}

	
	public static void sort(Comparable[] a, int choose, int depth) {
		// --------------------------------------------------------
		// Summary: This method is the public method that calls our actual sort private method
		// Precondition: a is an comparable array that we are going to sort, choose is an integer that represent
		// 				whether array will be sorted ascending or descending 
		//				depth is an integer that after depth reach 0 we call simply merge sort for that array
		// Postcondition: private sort method will be called
		// --------------------------------------------------------
		sort(a, 0, a.length - 1, choose, depth);
	}
	

	private static void sort(Comparable[] a, int lo, int hi, int choose, int depth) {
		// --------------------------------------------------------
		// Summary: This method will called recursively and sort the array after depth reach 0 merge sort will be called
		// Precondition: a is an comparable array that we are going to sort, lo is left pointer hi is the right 
		// 				pointer, choose is user choice for sorting descending or ascending
		//				depth is an integer shows us when merge sort should be called.
		// Postcondition: partition method will be called and it will call itself recursively, and merge sort will be called
		// --------------------------------------------------------
		if (depth == 0) {
			
			MergeSort ms = new MergeSort();
			ms.sort(a);
			return;
			
		}
		if (hi <= lo)
			return;
		
		int j = 0;
		
		if (choose == 0)
			j = partition(a, lo, hi); // Partition (see page 291).
		else if (choose == 1)
			j = partitionReverse(a, lo, hi);
		
		sort(a, lo, j - 1, choose, --depth); // Sort left part a[lo .. j-1].
	
		sort(a, j + 1, hi, choose, --depth); // Sort right part a[j+1 .. hi].
		

	}

	private static int partition(Comparable[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
		// --------------------------------------------------------
		// Summary: It finds first lower number (right pointer) and higher number(left pointer) 
		// 			than the pivot and then exchange their places 
		// Precondition: a is the array that we are sorting, lo is left pointer, hi is right pointer 
		// Postcondition: the numbers that shown with left and right pointers will be change places
		// --------------------------------------------------------
		int i = lo, j = hi + 1; // left and right scan indices
		
		Comparable v = a[lo]; // partitioning item
		
		while (true) { // Scan right, scan left, check for scan complete, and exchange.

			while (CustomClass.less(a[++i], v)) {
				if (i == hi)
					break;
			}

			while (CustomClass.less(v, a[--j])) {
				if (j == lo)
					break;
			}

			if (i >= j)
				break;
			CustomClass.exch(a, i, j);
		}
		CustomClass.exch(a, lo, j);
		// Put v = a[j] into position
		return j;
		// with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}

	private static int partitionReverse(Comparable[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i],
		// --------------------------------------------------------
		// Summary: It finds first lower number (left pointer) and higher number(right pointer) 
		// 			than the pivot and then exchange their places 
		// Precondition: a is the array that we are sorting, lo is left pointer, hi is right pointer 
		// Postcondition: the numbers that shown with left and right pointers will be change places
		// --------------------------------------------------------
		int i = lo, j = hi + 1;	// left and right scan indices

		Comparable v = a[lo]; // partitioning item
		
		while (true) { // Scan right, scan left, check for scan complete, and exchange.

			while (CustomClass.less(v, a[++i])) {
				if (i == hi)
					break;
			}

			while (CustomClass.less(a[--j], v)) {
				if (j == lo)
					break;
			}

			if (i >= j)
				break;
			CustomClass.exch(a, i, j);
		}
		
		CustomClass.exch(a, lo, j);
		// Put v = a[j] into position
		return j;
		// with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}
}
