package com.spring.structures.iterator;

public class LinkList {
	private Link first;

	public Link getFirst() {
		return first;
	}

	public void setFirst(Link first) {
		this.first = first;
	}

	public LinkList() {
		first = null;
	}

	public Boolean isEmpty() {
		return first == null;
	}

	public ListIterator getIterator() {
		return new ListIterator(this);
	}

	public void displayList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
}
