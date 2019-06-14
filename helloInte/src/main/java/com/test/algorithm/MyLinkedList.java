package com.test.algorithm;

class MyLinkedList {
    private Node head;
    private Node tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node();
        head.next = null;
        tail = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0){
            return -1;
        }
        if (index == 0){
            return head.value;
        }
        int i = 0;
        Node cur = head;
        while(i < index ){
            i++;
            cur = cur.next;
        }
        return cur.value;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node headNew = new Node();
        headNew.value = val;

        headNew.next = head;
        this.head = headNew;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node headNew = new Node();
        headNew.value = val;
        Node cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = headNew;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0 && head != null){
            addAtHead(val);
            return;
        }
        Node cur = head;
        int curIdx = 0;
        while (curIdx < index){
            curIdx++;
            cur = cur.next;
        }

    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        
    }
    class Node{
        Node next;
        int value;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */