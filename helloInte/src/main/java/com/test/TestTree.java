package com.test;

public class TestTree {
    private class TreeNode{
        public TreeNode leftChild;
        public TreeNode rightChild;
        public int value;
        public TreeNode(int v){
            value = v;
        }

    }

    public static void main(String[] args) {
        TestTree tt = new TestTree();
        tt.test();

    }

    public void test(){
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < 5; i++) {
            bst.insert(new TreeNode((int)Math.round(Math.random()*10% 10)));
        }
    }

    private  class  BinarySearchTree{
        TreeNode root;

        public void insert(TreeNode node){
            if (root == null){
                root = node;
                return;
            }
            TreeNode curNode = root;
            TreeNode parent = curNode;
            while (true){
                if (node.value <= curNode.value){
                    curNode = curNode.leftChild;
                    if (curNode == null){
                        parent.leftChild = node;
                        return;
                    }
                }else{
                    curNode = curNode.rightChild;
                    if (curNode == null) {
                        parent.rightChild = node;
                        return;
                    }
                }

            }
        }


    }

}
