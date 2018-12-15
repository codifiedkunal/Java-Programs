package com.kworld.dsalgo.linkedlist.single;

import static com.kworld.util.Util.logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/*
 * Test
 */
public class LinkedListTest {
	LinkedList<Integer> list;
	
	@Before
	public void init() {
		list = new LinkedList<>();
        logger.info("\nEmpty List " + list.toString());
        list.add(new LinkedList.Node<>(5));
        logger.info("\n1 Element " + list.toString());
        logger.info("\nDelete " + list.delete());
        list.add(new LinkedList.Node<>(14));
        list.add(new LinkedList.Node<>(12));
        list.add(new LinkedList.Node<>(2));
        list.add(new LinkedList.Node<>(90));
        list.add(new LinkedList.Node<>(44));
        list.add(new LinkedList.Node<>(7));
        list.add(new LinkedList.Node<>(90));
        list.add(new LinkedList.Node<>(41));
        logger.info("\nList After Adding All " + list.toString());
	}
	
	@Test
    public void testLinkList() {
        logger.info("\nDelete " + list.delete());
        logger.info("\nLast " + list.getLast());
        logger.info("\nFirst " + list.getFirst());
        logger.info("\nAll " + list.toString());
        logger.info("\nDelete " + list.delete(44));
        logger.info("\nLast " + list.getLast());
        logger.info("\nFirst " + list.getFirst());
        logger.info("\nAll " + list.toString());
    }
}
