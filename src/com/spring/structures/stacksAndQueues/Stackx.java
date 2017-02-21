package com.spring.structures.stacksAndQueues;

public class Stackx {

	private int maxSize;
	private char[] stackxArray;
	private int top;

	public Stackx(int initSize) {
		maxSize = initSize;
		stackxArray = new char[maxSize];
		top = -1;
	}

	public void push(char data) {
		stackxArray[++top] = data;
	}

	public char pop() {
		return stackxArray[top--];
	}

	public char peek() {
		return stackxArray[top];
	}

	public boolean isEmpty() {
		return -1 == top;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public int size() {
		return top + 1;
	}

	public char peekN(int n) {
		return stackxArray[n];
	}

	public void displayStack(String s) {
		System.out.print(s);
		System.out.print("Stack (button --> top): ");
		for (int i = 0; i < size(); i++) {
			System.out.print(peekN(i));
			System.out.print(' ');
		}
		System.out.println("");
	}
}
