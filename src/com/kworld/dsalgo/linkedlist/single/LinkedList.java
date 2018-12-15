package com.kworld.dsalgo.linkedlist.single;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {
    private Node<T> head = null;
    private int size = 0;

    public int add(Node<T> node){
        if(node == null)
            throw new InvalidParameterException("Can not add null to list");
        node.next = null;
        Node<T> navigate = head;
        if(navigate == null ){
            head = node;
        } else {
            while (navigate.next != null )
                navigate = navigate.next;
            navigate.next = node;
        }
        size++;
        return size;
    }

    public Node<T> delete(){
        Node<T> navigate = this.head;
        if(navigate == null)
            return null;
        if(navigate.next == null) {
            head = null;
            size--;
            return new Node<>(navigate);
        }
        Node<T> delete = navigate.next;
        do{
            delete = delete.next;
            navigate = navigate.next;
        } while(delete.next != null);
        navigate.next = null;
        size--;
        return new Node<>(delete);
    }

    public Node<T> delete(T value){
        Node<T> navigate, delete;
        navigate = delete = this.head;
        if(navigate == null)
            return null;
        if(navigate.data == value) {
            this.head = null;
            size--;
            return delete;
        }
        delete = navigate.next;
        while(navigate.next != null) {
            if(delete.data == value){
                navigate.next = delete.next;
                delete.next = null;
                size--;
                return delete;
            }
            navigate = navigate.next;
            delete = delete.next;
        }
        return null;
    }

    public Node<T> getLast() {
        if(this.head == null)
            return null;
        else {
            Node<T> last = this.head;
            if(last.next == null)
                return new Node<>(last);
            do{
                last = last.next;
            }while(last.next!= null);
            return new Node<>(last);
        }
    }

    public Node<T> getFirst() {
        if(this.head == null)
            return null;
        else
            return new Node<>(this.head);
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

        public Node(Node<T> node) {
            this.data = node.data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +  "data=" + data +  '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    @Override
    public String toString() {
        List<T> list = new ArrayList<>();
        Node<T> navigate = this.head;
        if(navigate != null){
            list.add(navigate.data);
            while(navigate.next != null){
                navigate = navigate.next;
                list.add(navigate.data);
            }
        }
        return "LinkedList" + list + " Size :" + this.getSize();
    }
}
