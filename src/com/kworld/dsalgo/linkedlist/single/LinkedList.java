package com.kworld.dsalgo.linkedlist.single;

import java.util.ArrayList;
import java.util.List;

//TODO Fix this program
public class LinkedList<T> {
    private Node<T> start = new Node<>();
    private int size = 0;

    public int add(Node<T> node){
        node.next = null;
        Node<T> navigate = start.next;
        if(navigate == null) {
            start.next = node;
        } else {
            while (navigate.next != null )
                navigate = navigate.next;
            navigate.next = node;
        }
        size++;
        return size;
    }

    public Node<T> delete(){
        Node<T> navigate = this.start.next;
        if(navigate == null)
            return navigate;
        Node<T> last = navigate.next;
        while(last.next != null) {
            navigate = navigate.next;
            last = last.next;
        }
        size--;
        return last;
    }

    public Node<T> delete(T value){
        Node<T> start = this.start.next;
        if(start == null)
            return start;
        Node<T> last = start.next;
        while(last.next != null) {
            start = start.next;
            last = last.next;
        }
        size--;
        return last;
    }

    public Node<T> getLast() {
        return null;
    }

    public Node<T> getFirst() {
        Node<T> first = new Node<>(start.next);
        first.next = null;
        return new Node<>(first);
    }

    public int getSize() {
        return size;
    }

    public static class Node<T>{
        private Node<T> next;
        private T data;

        public Node() {}

        public Node(T data) {
            this.data = data;
        }

        public Node(Node<T> next) {
            this.data = next.data;
            this.next = next.next;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +  "data=" + data +  '}';
        }
    }

    @Override
    public String toString() {
        List<T> list = new ArrayList<>();
        Node<T> start = this.start.next;
        if(start != null){
            list.add(start.data);
            while(start.next != null){
                start = start.next;
                list.add(start.data);
            }
        }
        return "LinkedList" + list + " Size :" + this.getSize();
    }
}
