package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import Models.CustomClass;
class CustomClassTest {

	@Test
	void exchange_test() {
		
		Comparable [] arr = {-3,5,1,2,75,3,1,4,86,23,521};
		CustomClass.exch(arr, 0, 1); // change -3 and 5's places
		assertEquals(5, arr[0]); // 0'th element should be 5
		
	}
	
	@Test 
	void less_test(){
		
		Comparable [] arr = {-3,5,1,2,75,3,1,4,86,23,521};
		
		//since -3 less than 5 it should return true
		assertEquals(true, CustomClass.less(arr[0], arr[1])); 
		
		
	}
	
	@Test 
	void less_test2(){
		
		Comparable [] arr = {-3,5,1,2,75,3,1,4,86,23,521};
		
		//since 5 bigger than -3 it should return false
		assertEquals(false, CustomClass.less(arr[1], arr[0])); 
		
		
	}
	
	@Test
	void load_test() {
		Comparable [] arr = CustomClass.load("input1", 0);
		
		Comparable [] result = {5, 1, 2, 89, 3, 9, 11, 12};
		
		assertEquals(result, arr);
	}
	

}
