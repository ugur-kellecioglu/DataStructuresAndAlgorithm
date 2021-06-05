package Models;

//-----------------------------------------------------
//Title: Event Model Class
//Author: Uğur Kellecioğlu
//ID: ****
//Section: 1
//Assignment: 4
//Description: This class implemented for modeling Events
//			   Since i use generic type in MyHeap class
//			   Event class should implement Comparable interface
//-----------------------------------------------------

public class Event implements Comparable<Event> {

	private String name;
	private long deadline;
	private long duration;

	public Event(String name, long deadline, long duration) {
		this.name = name;
		this.deadline = deadline;
		this.duration = duration;
	}

	public Event() {
	}

	// since it is comparable we have to impelement comparTo method
	@Override
	public int compareTo(Event e) {
		if (this.getDeadline() > e.getDeadline())
			return 1;
		else
			return 0;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDeadline() {
		return deadline;
	}

	public void setDeadline(long deadline) {
		this.deadline = deadline;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

}
