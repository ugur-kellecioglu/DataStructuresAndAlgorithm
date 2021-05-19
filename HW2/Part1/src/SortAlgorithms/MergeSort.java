package SortAlgorithms;

import Models.CustomClass;

//-----------------------------------------------------
//Title: Merge Sort
//Author: Uğur Kellecioğlu
//ID: ***
//Section: 1
//Assignment: 1
//Description: This class for sorting the given array with Merge sort algorithm.
//-----------------------------------------------------

public class MergeSort {

	private static Comparable[] aux; 

	public static void sort(Comparable[] a)
	// --------------------------------------------------------
	// Summary: This method starts the recursive function sort(a,lo,hi)
	// Precondition: a is an array that we are going to sort
	// Postcondition: sort method will be called
	// --------------------------------------------------------
	{
		// Allocate space just once.
		aux = new Comparable[a.length];

		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi)
	// --------------------------------------------------------
	// Summary: this method sorts the array ascending order with merge sort
	// algorithm
	// Precondition: a is an array which is Comparable and unordered,
	// less method is a static method from CustomClass for comparing two item
	// exch method is a static method from CustomClass for exchanging two item in
	// the given array
	// lo is an integer stands for the left side of the array
	// hi is an integer stands for the right side of the array
	// we need lo and hi for dividing array into half
	// Postcondition: a will be sorted.
	// --------------------------------------------------------
	{
		// if left pointer equal or bigger than the right pointer return nothing
		// base case for recursive
		if (hi <= lo)
			return;

		// for holding the mid of the array as index
		int mid = lo + (hi - lo) / 2;

		// Sort left half.
		sort(a, lo, mid);

		// Sort right half.
		sort(a, mid + 1, hi);

		merge(a, lo, mid, hi); // Merge results
	}

	
	public static void merge(Comparable[] a, int lo, int mid, int hi)
	// --------------------------------------------------------
	// Summary: This method puts items based on their compared results into aux array
	// Precondition: a is an array is a piece of array that is we get from recursive function
	//				lo is the left point, mid is mid point, hi is right point
	// Postcondition: aux array will be filled
	// --------------------------------------------------------
	{

		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++) { // copy elements from actual array to aux array
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) { // merge
			
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (CustomClass.less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}

		}
	}
}
