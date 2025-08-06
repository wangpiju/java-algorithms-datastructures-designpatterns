package datastructures;

import java.util.List;
import java.util.ArrayList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {
    /**
     * Test method to verify the three traversal methods
     */
    public static void main(String[] args) {
        // Create a sample binary tree:
        // 1
        // / \
        // 2 3
        // / \
        // 4 5

        Traversals<Integer> traversals = new Traversals<>();

        // Create tree nodes (TreeNode is static class)
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);

        // Build the tree structure
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        // Test preorder traversal (Root -> Left -> Right)
        List<Integer> preorderResult = traversals.preorder(root);
        System.out.println("Preorder traversal: " + preorderResult);
        // Expected: [1, 2, 4, 5, 3]

        // Test inorder traversal (Left -> Root -> Right)
        List<Integer> inorderResult = traversals.inorder(root);
        System.out.println("Inorder traversal:  " + inorderResult);
        // Expected: [4, 2, 5, 1, 3]

        // Test postorder traversal (Left -> Right -> Root)
        List<Integer> postorderResult = traversals.postorder(root);
        System.out.println("Postorder traversal: " + postorderResult);
        // Expected: [4, 5, 2, 3, 1]

        // Test with null root
        System.out.println("\nTesting with null root:");
        System.out.println("Preorder: " + traversals.preorder(null));
        System.out.println("Inorder:  " + traversals.inorder(null));
        System.out.println("Postorder: " + traversals.postorder(null));

        // Test with single node
        System.out.println("\nTesting with single node:");
        TreeNode<Integer> singleNode = new TreeNode<>(10);
        System.out.println("Preorder: " + traversals.preorder(singleNode));
        System.out.println("Inorder:  " + traversals.inorder(singleNode));
        System.out.println("Postorder: " + traversals.postorder(singleNode));
    }

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    public List<T> preorder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root != null) {
            result.add(root.data); // Visit root
            result.addAll(preorder(root.left)); // Traverse left subtree
            result.addAll(preorder(root.right)); // Traverse right subtree
        }
        return result;
    }

    public List<T> inorder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inorder(root.left)); // Traverse left subtree
            result.add(root.data); // Visit root
            result.addAll(inorder(root.right)); // Traverse right subtree
        }
        return result;
    }

    public List<T> postorder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root != null) {
            result.addAll(postorder(root.left)); // Traverse left subtree
            result.addAll(postorder(root.right)); // Traverse right subtree
            result.add(root.data); // Visit root
        }
        return result;
    }

    /**
     * Node class used for implementing the BST.
     *
     * DO NOT MODIFY THIS FILE!!
     *
     * @author CS 1332 TAs
     * @version 1.0
     */
    public static class TreeNode<T extends Comparable<? super T>> {

        private T data;
        private TreeNode<T> left;
        private TreeNode<T> right;

        /**
         * Constructs a TreeNode with the given data.
         *
         * @param data the data stored in the new node
         */
        TreeNode(T data) {
            this.data = data;
        }

        /**
         * Gets the data.
         *
         * @return the data
         */
        T getData() {
            return data;
        }

        /**
         * Gets the left child.
         *
         * @return the left child
         */
        TreeNode<T> getLeft() {
            return left;
        }

        /**
         * Gets the right child.
         *
         * @return the right child
         */
        TreeNode<T> getRight() {
            return right;
        }

        /**
         * Sets the data.
         *
         * @param data the new data
         */
        void setData(T data) {
            this.data = data;
        }

        /**
         * Sets the left child.
         *
         * @param left the new left child
         */
        void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        /**
         * Sets the right child.
         *
         * @param right the new right child
         */
        void setRight(TreeNode<T> right) {
            this.right = right;
        }
    }
}