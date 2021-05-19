import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//-----------------------------------------------------
//Title: Sorting tester class
//Author: Uğur Kellecioğlu
//ID: **
//Section: 1
//Assignment: 2
//Description: This class use the algorithms that provided by a referenced library
//				based on user's choice of arraysize, 
//           	array count and which algorithm user want.
//			    and print's time and average time of them. 
//-----------------------------------------------------


public class SortingAlgorithmTester {


	public static ArrayList<int[]> addArraysRandom(int arrayCount, int arraySize) 
	//--------------------------------------------------------
	// Summary: This method create arrays which is full of random integers and
	//          put them into an arraylist and return it
	// Precondition: arrayCount is an integer that represent how many array user want to create
	// arraysize is an integer that stands for size of the arrays that will created.
	// Postcondition: an arraylist that is full of arrays type of int returns.
	//--------------------------------------------------------
	{
		// for creating array that stores randomly generated numbers
		Random rnd = new Random();
		
		// array list for holding the arrays
		ArrayList<int[]> arrListRandom = new ArrayList<int[]>(); 
		
		// for loop for creating arrayCount times array
		for (int i = 0; i < arrayCount; i++) {
			
			int[] arr = new int[arraySize];
			
			// for loop for inserting randomly values into each array 
			for (int j = 0; j < arraySize; j++) {
				arr[j] = rnd.nextInt();
			}
			
			// add created array to arraylist 
			arrListRandom.add(arr);
		}
		
		return arrListRandom;
	}

	public static ArrayList<int[]> addArraysAscending(int arrayCount, int arraySize) 
	//--------------------------------------------------------
	// Summary: This method create arrays which is full of integers that is ordered ascending and
	//          put them into an arraylist and return it
	// Precondition: arrayCount is an integer that represent how many array user want to create
	// arraysize is an integer that stands for size of the arrays that will created.
	// Postcondition: an arraylist that is full of arrays type of int returns.
	//--------------------------------------------------------
	{
		
		// array list for holding the arrays
		ArrayList<int[]> arrListRandom = new ArrayList<int[]>();
		
		// for loop for creating arrayCount times array
		for (int i = 0; i < arrayCount; i++) {
			
			int[] arr = new int[arraySize];
			
			// for loop for inserting ascending integers into each array 
			for (int j = 0; j < arraySize; j++) {
				arr[j] = j;
			}
			
			// add created array to arraylist 
			arrListRandom.add(arr);
		}
		return arrListRandom;
	}
	
	public static ArrayList<int[]> addArraysDescending(int arrayCount, int arraySize) 
	//--------------------------------------------------------
	// Summary: This method create arrays which is full of integers that is ordered descending and
	//          put them into an arraylist and return it
	// Precondition: arrayCount is an integer that represent how many array user want to create
	// arraysize is an integer that stands for size of the arrays that will created.
	// Postcondition: an arraylist that is full of arrays type of int returns.
	//--------------------------------------------------------
	{
		// array list for holding the arrays
		ArrayList<int[]> arrListRandom = new ArrayList<int[]>();
		
		// for loop for creating arrayCount times array
		for (int i = 0; i < arrayCount; i++) {
			
			int[] arr = new int[arraySize];
			
			// for loop for inserting ascending integers into each array 
			for (int j = 0; j < arraySize; j++) {
				arr[j] = arraySize-j;
			}
			
			// add created array to arraylist 
			arrListRandom.add(arr);
		}
		return arrListRandom;
	}
	
	//This method for defining algorithm 3 and 4 due to they are so close each other.
	//But in larger arrays algorithm 3 was giving stackoverflow error and i don't know why.
	//I couldn't solve it but by looking smaller arrays i understand that algo 3 quick sort and algo 4  merge sort
	 public static ArrayList<int[]> addArraysSame(int arrayCount, int arraySize) 
	//--------------------------------------------------------
	// Summary: This method create arrays which is full of same integer
	// Precondition: arrayCount is an integer that represent how many array user want to create
	// arraysize is an integer that stands for size of the arrays that will created.
	// Postcondition: an arraylist that is full of arrays type of int returns.
	//--------------------------------------------------------
	{
		// array list for holding the arrays
		ArrayList<int[]> arrListRandom = new ArrayList<int[]>();
		
		// for loop for creating arrayCount times array
		for (int i = 0; i < arrayCount; i++) {
			
			int[] arr = new int[arraySize];
			
			// for loop for inserting ascending integers into each array 
			for (int j = 0; j < arraySize; j++) {
				arr[j] = 99999999;
			}
			
			// add created array to arraylist 
			arrListRandom.add(arr);
		}
		return arrListRandom;
	} 
	 
	
	
	
	private static void test(ArrayList<int[]> arrList, String algorithmChoice) 
	//--------------------------------------------------------
	// Summary: This method simply sorts the arrays in the arraylist that is given in the parameters
	//          and 
	// Precondition: arrayCount is an integer that represent how many array user want to create
	// arraysize is an integer that stands for size of the arrays that will created.
	// Postcondition: an arraylist that is full of arrays type of int returns.
	//--------------------------------------------------------
	{
		
		// start : algorithms start time
		// end : algorithms finish time
		// result : time difference between start time and end time
		// sum : for finding the algorithms average time
		long start, end, result, sum = 0;
		for (int i = 0; i < arrList.size(); i++) { // how many arrays are there
			
			switch (algorithmChoice) { // which algorithm is chosen
			case "1": {
				start = System.currentTimeMillis();
				SortingAlgorithms.sort1(arrList.get(i), 3046750472L);
				end = System.currentTimeMillis();
				break;
			}
			case "2": {
				start = System.currentTimeMillis();
				SortingAlgorithms.sort2(arrList.get(i), 3046750472L);
				end = System.currentTimeMillis();
				break;
			}
			case "3": {
				
				start = System.currentTimeMillis();
				SortingAlgorithms.sort3(arrList.get(i), 3046750472L);
				end = System.currentTimeMillis();
			
				break;
			}
			case "4": {
		
				start = System.currentTimeMillis();
				SortingAlgorithms.sort4(arrList.get(i), 3046750472L);
				end = System.currentTimeMillis();
			
				break;
			}
			case "5": {
				start = System.currentTimeMillis();
				SortingAlgorithms.sort5(arrList.get(i), 3046750472L);
				end = System.currentTimeMillis();
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + algorithmChoice);
			}
			
			result = end - start;
			sum += result;
			long resultInSecond = result/1000; // result in seconds
			
			// print the results
			System.out.print("Sort Algorithm "+algorithmChoice +", Time: "+ result +" milisecond\n");
		
		}
		 
		float average = sum / arrList.size(); // sum / size = average
		float averageInSecond = average/1000; // average in second
		System.out.println( "Size: " + arrList.get(0).length + ", Average: " + average +" milisecond\n");
		
		
		
	}

	private static void testIt(ArrayList<int[]> arrList, String[] algorithms) 
	//--------------------------------------------------------
	// Summary: This method create arrays which is full of integers that is ordered ascending and
	//          put them into an arraylist and return it
	// Precondition: arrayCount is an integer that represent how many array user want to create
	// arraysize is an integer that stands for size of the arrays that will created.
	// Postcondition: an arraylist that is full of arrays type of int returns.
	//--------------------------------------------------------
	{
		
		for (String algorithm : algorithms) {
			test(arrList, algorithm);
		}

	}

	public static void main(String[] args) 
	//--------------------------------------------------------
	// Summary: This method create arrays which is full of integers that is ordered ascending and
	//          put them into an arraylist and return it
	// Precondition: arrayCount is an integer that represent how many array user want to create
	// arraysize is an integer that stands for size of the arrays that will created.
	// Postcondition: an arraylist that is full of arrays type of int returns.
	//--------------------------------------------------------
	{
		ArrayList<int[]> arrListRandom = new ArrayList<int[]>(); // an arraylist to storing randomly generated arrays
		ArrayList<int[]> arrListAscending= new ArrayList<int[]>(); // an arraylist to storing ascending order sorted arrays
		ArrayList<int[]> arrListDescending = new ArrayList<int[]>(); // an arraylist to storing descending order sorted arrays
		ArrayList<int[]> arrListSame = new ArrayList<int[]>();
		Scanner scan = new Scanner(System.in); // scanner object to get inputs from user
		
		// instructions
		System.out.println("Please enter the algorithms that you want to run");
		System.out.println("Example input: 1 2 3 4 5");
		
		// get the input as an string array
		String[] algorithms = scan.nextLine().split(" ");
		
		// instruction
		System.out.println("How many array you want to create?");
		
		// get the array number that will be created
		int arrayNumber = scan.nextInt();
		scan.nextLine(); // just for skipping the nextline
		
		// instructions 
		System.out.println("What should be the size of them?");
		System.out.println("Example input 8000 16000 32000");
		
		// get the array's sizes as an array because it has multiple size functionality
		String [] arraySizeList = scan.nextLine().split(" ");
		
		// for each arraySize that choosen by user
		// N times random, ascending, descending array will created in arrList
		// Also N is choosen by the user at the beginning
		// finally test method will be called
		for(String s: arraySizeList) {
			
			int arraySize = Integer.parseInt(s); // make it an integer, bc we store it as an string 
			
			arrListRandom = addArraysRandom(arrayNumber, arraySize);
			arrListAscending = addArraysAscending(arrayNumber, arraySize);
			arrListDescending = addArraysDescending(arrayNumber, arraySize);
			arrListSame = addArraysSame(arrayNumber, arraySize);
			
			//instruction
			System.out.println("Randomly Generated Input Results:");
			System.out.println("----------");
			testIt(arrListRandom, algorithms); // call the method with arraylist and choosen algorithms
			System.out.println("##########\n");
			
			System.out.println("Ordered Input Results:");
			System.out.println("----------");
			testIt(arrListAscending, algorithms); // call the method with arraylist and choosen algorithms
			System.out.println("##########\n");
			
			System.out.println("Reverse Ordered Input Results:");
			System.out.println("----------");
			testIt(arrListDescending, algorithms); // call the method with arraylist and choosen algorithms
			System.out.println("##########\n");
			
			/*
			 System.out.println("Same Input Results:");
			System.out.println("----------");
			testIt(arrListSame, algorithms); // call the method with arraylist and choosen algorithms
			System.out.println("##########\n");
			 * */

		}


		scan.close(); // close the scan object
	}	
	

}
