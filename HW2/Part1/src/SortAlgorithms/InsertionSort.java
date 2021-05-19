package SortAlgorithms;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Models.CustomClass;

//-----------------------------------------------------
//Title: Insertion Sort
//Author: Uğur Kellecioğlu
//ID: ***
//Section: 1
//Assignment: 1
//Description: This class for sorting the given array with Insertion sort algorithm.
//-----------------------------------------------------

public class InsertionSort {

	public static void sort(Comparable[] inputArray)
	// --------------------------------------------------------
	// Summary: this method sorts the array ascending order
	// 		    with insertion sort algorithm
	// Precondition: inputArray is an array which is Comparable,
	// 				 less method is a static method from CustomClass for comparing two item
	// 				 exch method is a static method from CustomClass 
	// 				 for exchanging two item in	the given array
	// Postcondition: inputArray will be sorted.
	// --------------------------------------------------------
	{
		int aSize = inputArray.length;

		// for iterating through array
		for (int i = 0; i < aSize; i++) {

			// a variable that holds the max element
			int max = i;

			// iterating through array starting from i+1 th element
			// for finding bigger element than the i'th element
			for (int j = i + 1; j < aSize; j++) {

				// if j th element less than max'th element max will be j
				if (CustomClass.less(inputArray[j], inputArray[max])) {
					max = j;
				}

			}

			// exchange the i'th element and max'th element
			CustomClass.exch(inputArray, i, max);
		}

	}

	public static void sortReverse(Comparable[] inputArray)
	// --------------------------------------------------------
	// Summary: this method sorts the array 
	// 			descending order with insertion sort algorithm
	// Precondition: inputArray is an array which is Comparable,
	// 				 less method is a static method from CustomClass for comparing two item
	// 				 exch method is a static method from CustomClass for exchanging two item in
	// 				 the given array
	// Postcondition: inputArray will be sorted.
	// --------------------------------------------------------
	{
		int aSize = inputArray.length;

		// for iterating through array starting from the end of the array
		for (int i = aSize - 1; i >= 0; i--) {

			// a variable that holds the max element
			int max = i;

			// iterating through array starting from i-1 th element
			// for finding bigger element than the i'th element
			for (int j = i - 1; j >= 0; j--) {

				// if j th element less than max'th element max will be j
				if (CustomClass.less(inputArray[j], inputArray[max])) {
					max = j;
				}

			}
			// exchange the i'th element and max'th element
			CustomClass.exch(inputArray, i, max);
		}

	}
	

}
