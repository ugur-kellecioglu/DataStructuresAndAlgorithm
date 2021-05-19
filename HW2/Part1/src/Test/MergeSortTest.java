package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SortAlgorithms.MergeSort;

class MergeSortTest {

	MergeSort ms;
	@BeforeEach
	void initialize() {
		ms = new MergeSort();
	}
	
	@Test
	void asc_sort_test() {
		
		Comparable [] arr = {1,2,3,4,5,6,7};
		Comparable [] result = {1,2,3,4,5,6,7};
		ms.sort(arr);
		assertEquals(arr, result); // they should be equal
		
	}
	
	@Test
	void desc_sort_test() {
		
		Comparable [] arr = {5,4,3,2,1,-1};
		Comparable [] result = {-1,1,2,3,4,5};
		ms.sort(arr);
		assertEquals(arr, result); // they should be equal
		
	}

	@Test
	void random_sort_test() {
		Comparable [] arr = {1,6,4,2,3,9,7,8,5};
		Comparable [] result = {1,2,3,4,5,6,7,8,9};
		ms.sort(arr);
		assertEquals(arr, result); // they should be equal
	}

	@Test
	void string_sort_test() {
		Comparable[] arr = {"Uğur", "Kellecioğlu", "Ödev", "Al"};
		ms.sort(arr);
		assertEquals("Al", arr[0]);
	}
}
