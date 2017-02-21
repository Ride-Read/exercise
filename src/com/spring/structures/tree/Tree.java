package com.spring.structures.tree;

import java.util.Stack;

public class Tree {

	private Node root;

	public Tree() {
		root = null;
	}

	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (current.iData > key) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	public void insert(int iData, double dData) {
		Node newNode = new Node();
		newNode.iData = iData;
		newNode.dData = dData;
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (current.iData > iData) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeft = false;
		while (current.iData != key) {
			parent = current;
			if (key < current.iData) {
				isLeft = true;
				current = current.leftChild;
			} else {
				isLeft = false;
				current = current.rightChild;
			}
			if (current == null) {
				return false;
			}
		}
		if (current.leftChild == null && null == current.rightChild) {
			if (current == root) {
				root = null;
			} else if (isLeft) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (null == current.rightChild) {
			if (current == root) {
				root = current.leftChild;
			} else if (isLeft) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
		} else if (null == current.leftChild) {
			if (current == root) {
				root = current.rightChild;
			} else if (isLeft) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}

		} else {
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeft) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}

		return isLeft;

	}

	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			System.out.println("\nPreOrder traverse: ");
			preOrder(root);
			break;
		case 2:
			System.out.println("\nInOrder traverse: ");
			inOrder(root);
			break;
		case 3:
			System.out.println("\nPostOrder traverse: ");
			postOrder(root);
			break;
		}
		System.out.println();
	}

	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			preOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.rightChild);
		}
	}

	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}

	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("-----------------------------------------");
		while (false == isRowEmpty) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++) {
				System.out.print(" . ");
			}
			while (false == globalStack.isEmpty()) {
				Node temp = (Node) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if (temp.leftChild != null || temp.rightChild != null) {
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++) {
					System.out.print(" . ");
				}
			}
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false) {
				globalStack.push(localStack.pop());
			}
		}
		System.out.println("-----------------------------------------");
	}
}
