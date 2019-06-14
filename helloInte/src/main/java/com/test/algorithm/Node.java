package com.test.algorithm;

public class Node {
	public Node next;
	private String data;

	public Node(String data) {
		this.data = data;
	}

	public String data() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node next() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String toString() {
		return this.data;
	}
}