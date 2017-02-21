package com.spring.structures.iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterIterapp {
	public static void main(String[] args) throws IOException {
		LinkList theList = new LinkList();
		ListIterator iterator = theList.getIterator();
		iterator.insertAfter(20);
		iterator.insertAfter(40);
		iterator.insertAfter(80);
		iterator.insertBefore(60);
		long value;
		while (true) {
			System.out.print("Enter first letter of show,reset, ");
			System.out.print("next,get,before,after,delete:");
			System.out.flush();
			int choice = getChar();
			switch (choice) {
			case 's':
				if (!theList.isEmpty()) {
					theList.displayList();
				} else {
					System.out.println("List is empty");
				}
				break;
			case 'r':
				iterator.reset();
				break;
			case 'n':
				if (!theList.isEmpty() && !iterator.atEnd()) {
					iterator.nextList();
				} else {
					System.out.println("can't go to next link");
				}
				break;
			case 'g':
				if (!theList.isEmpty()) {
					value = iterator.getCurrent().dData;
					System.out.println("Returned " + value);
				} else {
					System.out.println("List is empty");
				}
				break;
			case 'b':
				System.out.print("Enter value to insert: ");
				System.out.flush();
				value = getInt();
				iterator.insertBefore(value);
				break;
			case 'a':
				System.out.print("Enter value to insert: ");
				System.out.flush();
				value = getInt();
				iterator.insertAfter(value);
				break;
			case 'd':
				if (!theList.isEmpty()) {
					value = iterator.deleteCurrent();
					System.out.println("Delete " + value);
				} else {
					System.out.println("Can't delete");
				}
				break;
			default:
				System.out.println("Invaild entry");
			}

		}
	}

	public static String getString() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		String str = reader.readLine();
		return str;
	}

	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}
