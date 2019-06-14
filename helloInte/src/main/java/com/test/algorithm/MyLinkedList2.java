package com.test.algorithm;

public class MyLinkedList2 {
	private Node head;
	private Node tail;

	public MyLinkedList2() {
		this.head = new Node("head");
		tail = head;
	}

	public Node head() {
		return head;
	}

	public void add(Node node) {
		tail.next = node;
		tail = node;
	}


}