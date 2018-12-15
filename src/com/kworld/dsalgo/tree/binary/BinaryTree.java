package com.kworld.dsalgo.tree.binary;

import static com.kworld.util.Util.logger;

public class BinaryTree<T> {
    Node<T> root = null;
    BinaryTree(){ }
    public void preOrder() {
    	this.preOrder(this.root);
    }
    
    private void preOrder(Node<T> node){
        if(node == null)
            return;
        logger.info(node.data + " - ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
    	this.inOrder(this.root);
    }
    
    private void inOrder(Node<T> node){
        if(node == null)
            return;
        inOrder(node.left);
        logger.info(node.data + " - ");
        inOrder(node.right);
    }

    public void postOrder() {
    	this.postOrder(this.root);
    }
    
    private void postOrder(Node<T> node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        logger.info(node.data + " - ");
    }
    
    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        Node() { }
        Node(T data) {
            this.data = data;
        }
    }
}


