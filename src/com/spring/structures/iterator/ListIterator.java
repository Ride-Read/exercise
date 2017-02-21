package com.spring.structures.iterator;

public class ListIterator {
	private Link current;
	private Link previous;
	private LinkList ourList;

	public ListIterator(LinkList list) {
		this.ourList = list;
	}

	public void reset() {
		this.current = ourList.getFirst();
		previous = null;
	}

	public boolean atEnd() {
		return current.next == null;
	}

	public void nextList() {
		this.previous = this.current;
		this.current = this.current.next;
	}

	public void insertAfter(long dd) {
		Link newLink = new Link(dd);
		if (ourList.isEmpty()) {
			ourList.setFirst(newLink);
			this.current = newLink;
		} else {
			newLink.next = current.next;
			current.next = newLink;
			nextList();
		}
	}

	public void insertBefore(long dd) {
		Link newLink = new Link(dd);
		if (ourList.isEmpty()) {
			ourList.setFirst(newLink);
			this.current = newLink;
			reset();
		} else {
			newLink.next = previous.next;
			previous.next = newLink;
			current = newLink;
		}
	}

	public long deleteCurrent() {
		long value = current.dData;
		if (previous == null) {
			ourList.setFirst(current.next);
			reset();
		} else {
			previous.next = current.next;
			if (atEnd()) {
				reset();
			} else {
				current = current.next;
			}
		}
		return value;
	}

	public Link getCurrent() {
		return current;
	}

	public void setCurrent(Link current) {
		this.current = current;
	}

	public Link getPrevious() {
		return previous;
	}

	public void setPrevious(Link previous) {
		this.previous = previous;
	}

	public LinkList getOurList() {
		return ourList;
	}

	public void setOurList(LinkList ourList) {
		this.ourList = ourList;
	}

}
