package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Person;
import SortAlgorithms.QuickSort;

class QuickSortTest {

	QuickSort qs;
	@BeforeEach
	void initialize() {
		qs = new QuickSort();
	}
	
	@Test
	void asc_sort_test() {
		
		Comparable [] arr = {1,2,3,4,5,6,7};
		Comparable [] result = {1,2,3,4,5,6,7};
		qs.sort(arr,0);
		assertEquals(arr, result); // they should be equal
		
	}
	
	@Test
	void desc_sort_test() {
		
		Comparable [] arr = {5,4,3,2,1,-1};
		Comparable [] result = {-1,1,2,3,4,5};
		qs.sort(arr,0);
		assertEquals(arr, result); // they should be equal
		
	}

	@Test
	void random_sort_test() {
		Comparable [] arr = {1,6,4,2,3,9,7,8,5};
		Comparable [] result = {1,2,3,4,5,6,7,8,9};
		qs.sort(arr,0);
		assertEquals(arr, result); // they should be equal
	}

	@Test
	void string_sort_test() {
		Comparable[] arr = {"Uğur", "Kellecioğlu", "Ödev", "Al"};
		qs.sort(arr,0);
		assertEquals("Al", arr[0]);
	}
	
	@Test
	void string_sort_desc_test() {
		Comparable[] arr = {"Uğur", "Kellecioğlu", "Ödev", "Al"};
		qs.sort(arr,1);
		assertEquals("Ödev", arr[0]);
	}
	
	@Test
	void asc_sort_desc_test() {
		
		Comparable [] arr = {1,2,3,4,5,6,7};
		Comparable [] result = {7,6,5,4,3,2,1};
		qs.sort(arr,1);
		assertEquals(arr, result); // they should be equal
		
	}
	
	@Test
	void random_sort_desc_test() {
		Comparable [] arr = {1,6,4,2,3,9,7,8,5};
		Comparable [] result = {9,8,7,6,5,4,3,2,1};
		qs.sort(arr,1);
		assertEquals(arr, result); // they should be equal
	}
	
	@Test
	void person_desc_sort_test() {
		Person [] persons = new Person [10];
		persons[0] = new Person("Uğur", "Kellecioğlu", 123L);
		persons[1] = new Person("Esra", "Kırmızı", 125L);
		persons[2] = new Person("Mehmet", "Yıldız", 113L);
		persons[3] = new Person("Sadet", "Eren", 1653L);
		persons[4] = new Person("Çiçek", "Gül", 12353L);
		persons[5] = new Person("Güneş", "Mutlu", 1231L);
		persons[6] = new Person("Ege", "Ağaç", 143L);
		persons[7] = new Person("Akdeniz", "Mavi", 193L);
		persons[8] = new Person("Ruhi", "Aşkın", 1323L);
		persons[9] = new Person("Sevgi", "Naif", 125L);
		qs.sort(persons, 0);
		assertEquals(113L, persons[0].getId());
	}
	
	@Test
	void person_asc_sort_test() {
		Person [] persons = new Person [10];
		persons[0] = new Person("Uğur", "Kellecioğlu", 123L);
		persons[1] = new Person("Esra", "Kırmızı", 125L);
		persons[2] = new Person("Mehmet", "Yıldız", 113L);
		persons[3] = new Person("Sadet", "Eren", 1653L);
		persons[4] = new Person("Çiçek", "Gül", 12353L);
		persons[5] = new Person("Güneş", "Mutlu", 1231L);
		persons[6] = new Person("Ege", "Ağaç", 143L);
		persons[7] = new Person("Akdeniz", "Mavi", 193L);
		persons[8] = new Person("Ruhi", "Aşkın", 1323L);
		persons[9] = new Person("Sevgi", "Naif", 125L);
		qs.sort(persons, 1);
		assertEquals(12353L, persons[0].getId());
	}

}
