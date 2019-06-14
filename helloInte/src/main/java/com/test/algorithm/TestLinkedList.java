package com.test.algorithm;

/**
 * ClassName: TestMyLinkedList
 * Function:  TODO
 * Date:      2019-06-11 21:23
 * author     daguang
 * version    V1.0
 */
public class TestLinkedList {
	public static void main(String[] args) {
		MyLinkedList2 myLinkedList2 = new MyLinkedList2();
		Node head = myLinkedList2.head();
		myLinkedList2.add(new Node("1"));
		myLinkedList2.add(new Node("2"));
		myLinkedList2.add(new Node("3"));
		myLinkedList2.add(new Node("4"));
		myLinkedList2.add(new Node("5"));

		Node current = head;
		Node mid = head;
		int len = 0;
		while (current.next != null) {
			len++;
			if (len % 2 == 0){
				mid = mid.next;
			}
			current = current.next;
		}
		System.out.println("len: "+len);
		System.out.println("mid: "+ mid);
	}


//	Read more: https://javarevisited.blogspot.com/2012/12/how-to-find-middle-element-of-linked-list-one-pass.html#ixzz5qXtyRTVd
}
