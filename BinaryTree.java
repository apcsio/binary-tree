package binarytree;

/**
 * Represents a binary search tree.
 * 
 * @author  Keshav Saharia
 *			keshav@techlabeducation.com
 */
public class BinaryTree {
	
	// Root of the tree
	Node root;
	
	/**
	 * Adds the given number to the binary tree.
	 * @param number - the number to add
	 */
	public void add(int number) {
		// The new node being added to the binary tree.
		Node newNode = new Node(number);
		
		// If there is no root node, then the root becomes this new node
		if (root == null) {
			root = newNode;
		}
		// Otherwise go down the tree and find the right spot for this node
		else {
			// Create a reference to the current node being considered
			Node current = root;
			
			// Keep going until the node is placed in the tree
			while (true) {
				// Greater values go to the right
				if (current.value < number) {
					// If there is a right node
					if (current.right != null) {
						current = current.right;
					}
					// Or there is no node, so the right node should become the new node.
					else {
						current.right = newNode;
						break;
					}
				}
				// Less than or equal values go to the left
				else {
					// If there is a left node, then go to it
					if (current.left != null) {
						current = current.left;
					}
					// Or there is no node, so the left node should become the new node.
					else {
						current.left = newNode;
						break;
					}
				}
			}
		}
	}
	
	/**
	 * Returns true or false if the binary tree contains the given number.
	 * @param number
	 * @return
	 */
	public boolean contains(int number) {
		// Start at the root node
		Node current = root;
		
		// While the current node is a valid (non-null) node
		while (current != null) {
			
			// Does the current node have the given value
			if (current.value == number) {
				return true;
			}
			
			// Go to the next node
			if (current.value < number) {
				// Go right
				current = current.right;
			}
			else {
				// Go left
				current = current.left;
			}
		}
		
		return false;
	}
	
	/**
	 * Removes a number from the binary tree.
	 * @param number
	 */
	public void remove(int number) {
		Node current = root;
		
		while (current != null) {
			// Put the left and right node into temporary variables
			Node leftChild = current.left;
			Node rightChild = current.right;
			
			// Four cases:
			// Case 1: current's left child the number I'm looking to remove
			if (leftChild != null && leftChild.value == number) {
				// Four cases again (yay :) )
				// Case 1: left child has a left and right child
				if (leftChild.left != null && leftChild.right != null) {
					// Start by assuming the in-order predecessor is the left child
					Node iop = leftChild.left;
					// Keep moving to the right as long as there is a node there
					while (iop.right != null) {
						// Get a reference to the right child of the IOP
						Node rightOfIOP = iop.right;
						// If the right child has a right child
						if (rightOfIOP.right != null) {
							iop = rightOfIOP;
						}
						else {
							// Remove the child from the parent of the IOP
							iop.right = null;
							iop = rightOfIOP;
						}
					}
					// Set the left child of current to the IOP
					current.left = iop;
					iop.right = leftChild.right;
				}
				// Case 2: left child only has a left child
				else if (leftChild.left != null && leftChild.right == null) {
					current.left = leftChild.left;
				}
				// Case 3: left child only has a right child
				else if (leftChild.left == null && leftChild.right != null) {
					current.left = leftChild.right;
				}
				// Case 4: left child is all alone :(
				else {
					current.left = null;
				}
				
			}
			// Case 2: current's right child the number I'm looking to remove
			else if (rightChild != null && rightChild.value == number) {
				current.right = null;
			}
			// Case 3: current is smaller than the number I'm looking for
			else if (current.value < number) {
				current = current.right;
			}
			// Case 4: current is bigger 
			else {
				current = current.left;
			}
		}
	}
	
	/**
	 * Print the binary tree out.
	 */
	public void print() {
		printNode(root);
	}
	
	public void printNode(Node n) {
		if (n != null) {
			System.out.println(n.value);
			printNode(n.left);
			printNode(n.right);
		}
	}
	
}
