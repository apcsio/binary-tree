package binarytree;

/**
 * Represents a node of a binary tree.
 * 
 * @author  Keshav Saharia
 *			keshav@techlabeducation.com
 */
public class Node {
	// The value stored by this node.
	int value;
	
	// References to the left and right node
	Node left;
	Node right;
	
	/**
	 * Construct a node with the given value.
	 * @param v
	 */
	public Node(int v) {
		value = v;
	}
}
