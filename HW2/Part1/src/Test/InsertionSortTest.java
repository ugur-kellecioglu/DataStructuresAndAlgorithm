package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.CustomClass;
import SortAlgorithms.InsertionSort;
class InsertionSortTest {

	// Creating an instance from InsertionSort class
	InsertionSort is;
	@BeforeEach
	void initialize() {
		is = new InsertionSort();  // initialize it
	}
	
	@Test
	void asc_sort_asc_test() {
		
		Comparable [] arr = {1,2,3,4,5,6,7};
		Comparable [] result = {1,2,3,4,5,6,7};
		is.sort(arr);
		assertEquals(arr, result); // they should be equal
		
	}
	
	@Test
	void desc_sort_asc_test() {
		
		Comparable [] arr = {5,4,3,2,1,-1};
		Comparable [] result = {-1,1,2,3,4,5};
		is.sort(arr);
		assertEquals(arr, result); // they should be equal
		
	}

	@Test
	void random_sort_asc_test() {
		Comparable [] arr = {1,6,4,2,3,9,7,8,5};
		Comparable [] result = {1,2,3,4,5,6,7,8,9};
		is.sort(arr);
		assertEquals(arr, result); // they should be equal
	}
	
	@Test
	void asc_sort_desc_test() {
		
		Comparable [] arr = {1,2,3,4,5,6,7};
		Comparable [] result = {7,6,5,4,3,2,1};
		is.sortReverse(arr);
		assertEquals(arr, result); // they should be equal
		
	}
	
	@Test
	void desc_sort_desc_test() {
		
		Comparable [] arr = {5,4,3,2,1,-1};
		Comparable [] result = {5,4,3,2,1,-1};
		is.sortReverse(arr);
		assertEquals(arr, result); // they should be equal
		
	}

	@Test
	void random_sort_desc_test() {
		Comparable [] arr = {1,6,4,2,3,9,7,8,5};
		Comparable [] result = {9,8,7,6,5,4,3,2,1};
		is.sortReverse(arr);
		assertEquals(arr, result); // they should be equal
	}
	
	
	@Test
	void txtfile_integer_sort_test_asc() {
		Comparable[] integers = CustomClass.load("input1", 0);
		Comparable[] arr = {1,2,3,5,9,11,12,89}; 
		is.sort(integers);
		assertEquals(arr, integers);
	}
	
	@Test
	void txtfile_double_sort_test_asc() {
		Comparable[] doubles = CustomClass.load("input2", 1);
		Comparable[] arr = {-432.32, 3.0, 3.0, 4.0, 11.0, 11.0, 14.0, 15.0, 23.3, 43.0, 43.1, 432.32};
		is.sort(doubles);
	
		assertEquals(arr, doubles);
	}
	
	@Test
	void txtfile_integer_sort_test_desc() {
		Comparable[] integers = CustomClass.load("input1", 0);
		Comparable[] arr = {89,12,11,9,5,3,2,1}; 
		is.sortReverse(integers);
		assertEquals(arr, integers);
	}
	
	@Test
	void txtfile_double_sort_test_desc() {
		Comparable[] doubles = CustomClass.load("input2", 1);
		Comparable[] arr = {432.32, 43.1, 43.0, 23.3, 15.0, 14.0, 11.0, 11.0, 4.0, 3.0, 3.0, -432.32};
		
		is.sortReverse(doubles);
	
		assertEquals(arr, doubles);
	}

}
