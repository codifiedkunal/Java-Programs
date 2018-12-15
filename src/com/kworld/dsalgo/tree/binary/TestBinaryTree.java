package com.kworld.dsalgo.tree.binary;

import org.junit.Before;
import org.junit.Test;

import static com.kworld.util.Util.logger;
public class TestBinaryTree {
	BinaryTree<Integer> tree ;
	
	@Before
	public void init() {
		tree = new BinaryTree<>();
		tree.root = new BinaryTree.Node(50);
		tree.root.left = new BinaryTree.Node(10);
		tree.root.right = new BinaryTree.Node(56);
		tree.root.left.left = new BinaryTree.Node(99);
		tree.root.left.right= new BinaryTree.Node(200);
		tree.root.right.right = new BinaryTree.Node(101);
	}
	
	@Test
	public void testDFSTraversal() {
		tree.preOrder();
		logger.info("\n");
		tree.inOrder();
		logger.info("\n");
		tree.postOrder();
	}
}
