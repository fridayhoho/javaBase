package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinterTest {



    public static void main(String[] args) {

//        BTreePrinter.printNode(test1());
//        BTreePrinter.printNode(test2());
        Node<Integer> root = new Node<Integer>(2);
        BTreePrinter.printNode(root);

        BTreePrinter.insert(root, new Node<Integer>(7));
        BTreePrinter.insert(root, new Node<Integer>(5));
        BTreePrinter.insert(root, new Node<Integer>(2));
        BTreePrinter.insert(root, new Node<Integer>(6));
        BTreePrinter.insert(root, new Node<Integer>(3));
        BTreePrinter.insert(root, new Node<Integer>(6));
        BTreePrinter.insert(root, new Node<Integer>(5));
        BTreePrinter.insert(root, new Node<Integer>(8));
        BTreePrinter.insert(root, new Node<Integer>(4));
        BTreePrinter.insert(root, new Node<Integer>(5));
        BTreePrinter.insert(root, new Node<Integer>(8));
        BTreePrinter.insert(root, new Node<Integer>(4));
        BTreePrinter.insert(root, new Node<Integer>(5));
        BTreePrinter.insert(root, new Node<Integer>(8));
        BTreePrinter.printNode(root);
    }
}

class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    public static void insert(Node root, Node newNode){
        if(root == null){
            root = newNode;
            return;
        }
        Node curNode = root;
        Node parent = root;
        while (true){
            parent = curNode;
            if (newNode.data.compareTo(curNode.data) < 0 ){
                curNode = curNode.left;
                if (curNode == null){
                    parent.left = newNode;
                    return;
                }
            }else{
                curNode = curNode.right;
                if (curNode == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}