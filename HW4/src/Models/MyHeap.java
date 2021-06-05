package Models;
import java.util.Collections;
import java.util.Vector;

//-----------------------------------------------------
//Title: Custom Heap Title
//Author: Uğur Kellecioğlu
//ID: ****
//Section: 1
//Assignment: 4
//Description: This class implements the heap data structure
//-----------------------------------------------------

public class MyHeap<Key extends Comparable<Key>> {

	private Vector<Key> pq;

	public MyHeap() {
		pq = new Vector<Key>();
		insert((Key) new Event()); // to start at 1st index
	}

	public boolean isEmpty()
	// --------------------------------------------------------
	// Summary: Assigns a value to the variable whose
	// name is given.
	// Precondition: varName is a char and varValue is an
	// integer
	// Postcondition: The value of the variable is set.
	// --------------------------------------------------------
	{
		return pq.size() == 1; // it is empty when its size one because we put an 
	}

	public void insert(Key key)
	// --------------------------------------------------------
	// Summary: Assigns a value to the variable whose
	// name is given.
	// Precondition: varName is a char and varValue is an
	// integer
	// Postcondition: The value of the variable is set.
	// --------------------------------------------------------
	{

		pq.add(key); // we add Key into heap
		swim(pq.size() - 1); // last item will be placed its right place
		
	}

	private void swim(int k)
	// --------------------------------------------------------
	// Summary: changes position of nodes and its child 
	// Precondition: k is an integer which shows the index 
	// 				 of node that will swim
	// Postcondition: k'th element will be placed its correct place
	// --------------------------------------------------------
	{
		// as long as k'th element is not root
		// and k'th element is less than k/2
		while (k > 1 && less(k / 2, k)) { 
			exch(k, k / 2); // swap them
			k = k / 2; // for looking further 
		}
		
	}

	private void exch(int k, int i)
	// --------------------------------------------------------
	// Summary: exchange position of k'th element and i'th element in the array
	// Precondition: k and i are integers that stands for indexes in the array
	// Postcondition: k'th element and i'th element will be swapped 
	// --------------------------------------------------------
	{
		// easier but i'm not sure it is allowed or not 
		// Collections.swap(pq, k, i);
		
		Key key = pq.get(i);
		pq.set(i, pq.get(k));
		pq.set(k, key);
		
	}

	private boolean less(int i, int k)
	// --------------------------------------------------------
	// Summary: compare i'th item and k'th item
	// Precondition: k and i are integers that stands for indexes in the array
	// Postcondition: a boolean value will be returned according to comparison
	// --------------------------------------------------------
	{
		// if k'th element is less than i'th element return true
		if (pq.get(i).compareTo(pq.get(k)) > 0) {
			return true;
		} else {
			return false;
		}

	}

	private void sink(int k)
	// --------------------------------------------------------
	// Summary: changes position of child and its parent 
	// Precondition: k is an integer which shows the index 
	// 				 of node that will sink
	// Postcondition: k'th element will be placed its correct place
	// --------------------------------------------------------
	{
		// as long as k is not the last item
		while (2 * k <= pq.size() - 1) { 
			int j = 2 * k; // j is child node
			
			// which one is smaller left child or right child?
			// j will be smallest
			if (j < pq.size() - 1 && less(j, j + 1))
				j++;
			
			// if child node is bigger than parent node break
			if (!less(k, j)) 
				break;
			
			//swap parent node and child nodes indexes
			exch(k, j);
			k = j;
		}
	}

	public Key delMin()
	// --------------------------------------------------------
	// Summary: delete the min key in the array
	// Precondition: pq is an heap data structure
	// Postcondition: first element which has smallest deadline will be deleted 
	// --------------------------------------------------------
	{
		
		Key min = pq.get(1); // smallest item is the 1'th item because it is an minHeap
		
		exch(1, pq.size() - 1); // swap min item and the last item in the heap
		
		pq.remove(pq.size() - 1); // remove the last item which is min item
		
		sink(1); // find the correct position for the new root
		
		return min;
	}
}
