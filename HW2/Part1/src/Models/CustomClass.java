package Models;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//-----------------------------------------------------
//Title: Custom Class
//Author: Uğur Kellecioğlu
//ID: ***
//Section: 1
//Assignment: 1
//Description: This class for providing some common methods to other classes,
//             we can access these methods statically 
//-----------------------------------------------------

public class CustomClass {

	private static File open_file(String file_name)
	// --------------------------------------------------------
	// Summary: This method create an File object and return it
	// Precondition: file_name is a string denoting the file name that wanted to be
	// opened
	// Postcondition: a file object created with the file_name variable and returned
	// --------------------------------------------------------
	{
		return new File(file_name + ".txt");
	}

	private static Scanner scan_file(String file_name)
	// --------------------------------------------------------
	// Summary: This method creates an Scanner object
	// Precondition: file_name is a string denoting the 
	// 				 file name that wanted to be opened
	// 				 open_file is a method that returns a file object
	// Postcondition: a scanner object created with the File
	// 				  object that returned from open_file method
	// --------------------------------------------------------
	{

		try {
			return new Scanner(open_file(file_name));
		} catch (FileNotFoundException e) {
			System.out.println("Hata");
			return null;
		}

	}

	private static int count_line(Scanner scan)
	// --------------------------------------------------------
	// Summary: This method counts the lines that the txt file has and return it
	// Precondition: Scanner is an object that we are 
	// 				 going to use iterate through file
	// Postcondition: count is a variable that holds how many line txt file has.
	// --------------------------------------------------------
	{

		int count = 0;

		while (scan.hasNext()) { // as long as the file has next line 

			count++; // increase the line counter
			scan.nextLine(); // go to the next line

		}
		return count;
	}

	public static Comparable[] load(String file_name, int choose)
	// --------------------------------------------------------
	// Summary: This method enters the inputs to array from txt file
	// Precondition: file_name is a string represent 
	// 			     the file name that we are going to scan
	// 				 choose is an integer for whether inputs will be integer or double
	// 				 0 stands for integer input, 1 stands for double inputs
	// Postcondition: ca is an Comparable array that is full of inputs
	// --------------------------------------------------------
	{

		Scanner scan = scan_file(file_name); // Scanner for getting the inputs from txt file

		int count = count_line(scan_file(file_name)); // How many line do txt file have?

		int iter = 0; // iterator that each time we put an item to array we increase its number
					  // it helps us to put items to correct indexes.

		Comparable[] ca = new Comparable[count]; // array we are going to fill

		if (choose == 0) { // integers

			while (scan.hasNext()) { // since there is a next line

				ca[iter] = scan.nextInt(); // take the input as integer an put it to array
				iter++; // increase iter's value by one for next item

			}

		} else if (choose == 1) { // doubles

			while (scan.hasNext()) { // since there is a next line

				ca[iter] = scan.nextDouble();// take the input as double an put it to array
				iter++; // increase iter's value by one for next item

			}

		}

		return ca; // finally return the array
	}

	public static boolean less(Comparable firstItem, Comparable secondItem)
	// --------------------------------------------------------
	// Summary: This method compare two parameters and if firstItem is 
	// 			less than secondItem return true
	// Precondition: firstItem and secondItem are comparable items 
	// 				 that we are going to compare
	// Postcondition: it will return true or false according to 
	// 				  secondItem is bigger than the first one or not
	// --------------------------------------------------------
	{

		return firstItem.compareTo(secondItem) < 0; // return true if secondItem is bigger than firstItem
	}

	public static void exch(Comparable[] array, int i, int j)
	// --------------------------------------------------------
	// Summary: This method swaps two items places with each other in an array
	// Precondition: array is an Comparable array that we have items in it, 
	// 				 i and j are indexes that we are going to swap their items.
	// Postcondition: ith element and jth element will be swapped
	// --------------------------------------------------------
	{
		Comparable t = array[i]; // temporary variable
		array[i] = array[j]; // ith element has jth elements value now.
		array[j] = t; // jth element has ith elements value now (since t holds the first value of ith)
	}

	public static void print(Comparable[] comp)
	// --------------------------------------------------------
	// Summary: This method prints the items in the array
	// Precondition: comp is an array type of Comparable
	// Postcondition: each item in the array will be printed.
	// --------------------------------------------------------
	{
		for (int i = 0; i < comp.length; i++) { // how many items array has

			System.out.println(comp[i]); // print ith element

		}

		System.out.println("-----");
	}

}
