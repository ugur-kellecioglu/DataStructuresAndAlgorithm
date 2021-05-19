package Models;
//-----------------------------------------------------
//Title: Person Class
//Author: Uğur Kellecioğlu
//ID: ***
//Section: 1
//Assignment: 1
//Description: Create a Person class that implements Comparable interface and 
//             have attributes such as name, surname and id
//-----------------------------------------------------
public class Person implements Comparable<Person> {
	
	// Variables that we are given and a person should have.
	private String name;
	private String surname;
	private long id;

	// Constructor
	public Person(String name, String surname, long id) {
		this.name = name;
		this.surname = surname;
		this.id = id;
	}

	@Override
	public int compareTo(Person p)
	// --------------------------------------------------------
	// Summary: Since we implement the Comparable interface we have to impelement
	// 			its methods as well.
	// 			compareTo method will compare two persons ids and return integer .
	// Precondition: p is an Person object that we are going to 
	// 				 compare with this object.
	// Postcondition: an integer will be returned
	// --------------------------------------------------------
	{
		if (this.id > p.id)
			return 1; // if this objects id bigger than the p's id return 1
		else if (this.id < p.id)
			return -1; // if less than p's return -1
		else
			return 0; // otherwise they are equal return 0
	}

	// to print it
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", id=" + id + "]";
	}

	// to access person's id from other packages
	public long getId() {
		return id;
	}


	
}
