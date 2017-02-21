package com.spring.structures.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeApp {
	public static void main(String[] args) throws IOException {
		int value;
		Tree theTree = new Tree();
		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);
		while (true) {
			System.out.print("Enter first letter show, ");
			System.out.print("insert,find,delete,or traverse: ");
			int choice = getChar();
			switch (choice) {
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = getInt();
				theTree.insert(value, value + 0.9);
				break;
			case 'f':
				System.out.print("Enter value to find: ");
				value = getInt();
				Node found = theTree.find(value);
				if (null != found) {
					System.out.print("Found: ");
					found.display();
					System.out.print("\n");
				} else {
					System.out.print("Could not found: ");
					System.out.print(value + "\n");
				}
				break;
			case 'd':
				System.out.print("Enter value to delete: ");
				value = getInt();
				boolean didDelete = theTree.delete(value);
				if (didDelete) {
					System.out.print("Delete: " + value + "\n");
				} else {
					System.out.print("Could not delete: ");
					System.out.print(value + "\n");
				}
				break;
			case 't':
				System.out.print("Enter type 1, 2 or 3: ");
				value = getInt();
				theTree.traverse(value);
				break;
			default:
				System.out.print("Invalid entry\n");
			}
		}
	}

	public static String getString() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(input);
		String str = buf.readLine();
		return str;
	}

	public static char getChar() throws IOException {
		String str = getString();
		return str.charAt(0);
	}

	public static int getInt() throws IOException {
		String str = getString();
		return Integer.parseInt(str);
	}
}
