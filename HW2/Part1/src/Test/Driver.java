package Test;

import Models.CustomClass;
import Models.Person;
import SortAlgorithms.InsertionSort;
import SortAlgorithms.MergeSort;
import SortAlgorithms.QuickSort;

public class Driver {
	
	public static Comparable[] arr, arr1,  arr2, arr3, arr4;
	
 	public static void createArrays() {
 		arr = CustomClass.load("input3", 0); //integer
		arr1 = CustomClass.load("input4", 1); // double
		
		Comparable [] temparr2 = {1,2,5325,613,5123,635,723,634,235,1234,-542,3215-455,-32};
		Comparable [] temparr3 = {"A", "B", "C", "D","E","Y","Ü", "Ç"};
		Comparable [] temparr4 = {new Person("Uğur", "Kellecioğlu", 43123L), 
							new Person("Leyla", "Kımız", 123L),
							new Person("Kuzu", "Tarkan", 5412L),
							new Person("AyaBenzer", "Yüreğim", 654712L)
							};
		arr2 = temparr2;
		arr3 = temparr3;
		arr4 = temparr4;
		
	}

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		MergeSort ms = new MergeSort();
		QuickSort qs = new QuickSort();
		
		System.out.println("Insertion Sort Test");
		createArrays();
		CustomClass.print(arr);
		is.sort(arr);
		CustomClass.print(arr);
		

	}

}
