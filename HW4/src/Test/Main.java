package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Models.Event;
import Models.MyHeap;

//-----------------------------------------------------
//Title: Tester  Class
//Author: Uğur Kellecioğlu
//ID: ****
//Section: 1
//Assignment: 4
//Description: This class for testing our classes with given inputs
//-----------------------------------------------------

public class Main {
	public static void main(String[] args) {

		// create a file object
		File file = new File("sampleinput1.txt");

		// create a scanner object to read our file
		Scanner scan = null;

		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		MyHeap mh = new MyHeap(); // create an object
		long time = 0; // declare & initialize time to 0

		// as long as there is a line in the file
		while (scan.hasNextLine()) {

			// take the line as an array
			String inputs[] = scan.nextLine().split(" ");

			String command = inputs[0]; // schedule or run?

			switch (command) {

			case "schedule": {

				String event_name = inputs[1]; // event name
				long deadline = Long.parseLong(inputs[2]); // deadline
				long duration = Long.parseLong(inputs[3]); // how much time it will take to complete the event

				Event e = new Event(event_name, deadline, duration); // create a Event instance
				mh.insert(e); // add event to our heap

				System.out.println(time + ": adding " + e.getName() + " with deadline " + e.getDeadline()
						+ " and duration " + e.getDuration()); // print information

				break;
			}
			case "run": {

				long bound = Long.parseLong(inputs[1]); // upper limit

				while (!mh.isEmpty()) { // as long as our heap is not empty

					Event e = (Event) mh.delMin(); // delete the event that has min deadline

					System.out.println(time + ": busy with " + e.getName() + " with deadline " + e.getDeadline()
							+ " and duration " + e.getDuration()); // print information

					boolean check = false; 

					while ((time + e.getDuration()) > bound) { // if we exceed the upper-limit when we do that job

						if (bound == time) { // check whether we reach the upper limit or not?
							check = true; // if we reach we shouldn't do that job
							break; // exit the loop
						}

						// if we have time to do some job
						e.setDuration(e.getDuration() + time - bound); // set events time after we did some parts of that job
						time = bound; // we reach the bound 
						mh.insert(e); // we add the event with its new duration

						System.out.println(time + ": adding " + e.getName() + " with deadline " + e.getDeadline()
								+ " and duration " + e.getDuration()); //print new information

					}

					if (check) // we reach the upper limit so we shouldn't do anything exit from outer loop
						break;

					time += e.getDuration(); // we sum duration and time

					System.out.println(time + ": done with " + e.getName()); // print info
				}

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + command);
			}

		}

	}

}
