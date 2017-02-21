package com.spring.structures.stacksAndQueues;

public class InToPost {
	private Stackx theStackx;
	private String input;
	private String output = "";

	public InToPost(String in) {
		input = in;
		theStackx = new Stackx(input.length());
	}

	public String doTrans() {
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			theStackx.displayStack("For " + ch + " ");
			switch (ch) {
			case '+':
			case '-':
				gotOper(ch, 1);
				break;

			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '(':
				theStackx.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;

			default:
				output = output + ch;
				break;
			}
		}
		while (!theStackx.isEmpty()) {
			theStackx.displayStack("while ");
			output = output + theStackx.pop();
		}
		theStackx.displayStack("End ");
		return output;
	}

	public void gotOper(char opThis, int prec1) {
		while (!theStackx.isEmpty()) {
			char opTop = theStackx.pop();
			if (opTop == '(') {
				theStackx.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop == '+' || opTop == '-') {
					prec2 = 1;
				} else {
					prec2 = 2;
				}
				if (prec2 < prec1) {
					theStackx.push(opTop);
					break;
				} else {
					output = output + opTop;
				}
			}
		}
		theStackx.push(opThis);
	}

	public void gotParen(char ch) {
		while (!theStackx.isEmpty()) {
			char chx = theStackx.pop();
			if (chx == '(') {
				break;
			} else {
				output = output + chx;
			}
		}
	}
}
