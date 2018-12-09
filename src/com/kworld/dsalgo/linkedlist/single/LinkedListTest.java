package com.kworld.dsalgo.linkedlist.single;

/*
 * Test
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("Empty List " + list.toString());
        list.add(new LinkedList.Node<>(5));
        System.out.println("1 Element " + list.toString());
        System.out.println("Delete " + list.delete());
        list.add(new LinkedList.Node<>(14));
        list.add(new LinkedList.Node<>(12));
        list.add(new LinkedList.Node<>(2));
        list.add(new LinkedList.Node<>(90));
        list.add(new LinkedList.Node<>(44));
        list.add(new LinkedList.Node<>(7));
        list.add(new LinkedList.Node<>(90));
        System.out.println("List After Adding All " + list.toString());
        System.out.println("Delete " + list.delete());
        System.out.println("Last " + list.getLast());
        System.out.println("First " + list.getFirst());
        System.out.println("All " + list.toString());
    }
}
