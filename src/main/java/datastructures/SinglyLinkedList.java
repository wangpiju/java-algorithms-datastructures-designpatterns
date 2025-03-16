package datastructures;

import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {
    /**
     * Node class used for implementing the SinglyLinkedList.
     *
     */
    public static class SinglyLinkedListNode<T> {

        private T data;
        private SinglyLinkedListNode<T> next;

        /**
         * Constructs a new SinglyLinkedListNode with the given data and next node
         * reference.
         *
         * @param data the data stored in the new node
         * @param next the next node in the list
         */
        SinglyLinkedListNode(T data, SinglyLinkedListNode<T> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Creates a new SinglyLinkedListNode with only the given data.
         *
         * @param data the data stored in the new node
         */
        SinglyLinkedListNode(T data) {
            this(data, null);
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
         * Gets the next node.
         *
         * @return the next node
         */
        SinglyLinkedListNode<T> getNext() {
            return next;
        }

        /**
         * Sets the next node.
         *
         * @param next the new next node
         */
        void setNext(SinglyLinkedListNode<T> next) {
            this.next = next;
        }
    }

    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
      
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to list.");
        }

        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        newNode.setNext(head);
        head = newNode;

        if (size == 0) {
            tail = newNode;
        }

        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {

        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to list.");
        }

        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {

        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from an empty list.");
        }

        T removedData = head.getData();
        head = head.getNext();
        size--;

        if (size == 0) {
            tail = null;
        }

        return removedData;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {

        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from an empty list.");
        }

        if (size == 1) {
            T removedData = head.getData();
            head = null;
            tail = null;
            size = 0;
            return removedData;
        }

        SinglyLinkedListNode<T> current = head;

        while (current.getNext() != tail) {
            current = current.getNext();
        }

        T removedData = tail.getData();
        current.setNext(null);
        tail = current;
        size--;
        return removedData;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Simple main test
     */
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        System.out.println("\n=== Test addToFront ===");
        list.addToFront(3); // List: 3
        list.addToFront(2); // List: 2 -> 3
        list.addToFront(1); // List: 1 -> 2 -> 3

        // validate size and order
        System.out.println("Expected size = 3, actual = " + list.size());
        System.out.println("Head data = " + list.getHead().getData()); // head is 1
        System.out.println("Tail data = " + list.getTail().getData()); // tail should be 3

        System.out.println("\n=== Test addToBack ===");
        list.addToBack(4); // List: 1 -> 2 -> 3 -> 4
        list.addToBack(5); // List: 1 -> 2 -> 3 -> 4 -> 5

        System.out.println("Expected size = 5, actual = " + list.size());
        System.out.println("Head data = " + list.getHead().getData()); // head is still 1
        System.out.println("Tail data = " + list.getTail().getData()); // tail should be 5

        System.out.println("\n=== Test removeFromFront ===");
        Integer frontRemoved = list.removeFromFront(); // remove 1
        System.out.println("Removed from front: " + frontRemoved);
        System.out.println("Expected size = 4, actual = " + list.size());
        System.out.println("New head data = " + list.getHead().getData()); // now head is 2
        System.out.println("Tail data = " + list.getTail().getData()); // tail is still 5

        System.out.println("\n=== Test removeFromBack ===");
        Integer backRemoved = list.removeFromBack(); // remove 5
        System.out.println("Removed from back: " + backRemoved);
        System.out.println("Expected size = 3, actual = " + list.size());
        System.out.println("New tail data = " + list.getTail().getData()); // now tail is 4

        System.out.println("\n=== final list ===");
        // simple print the remaining nodes
        SinglyLinkedListNode<Integer> current = list.getHead();
        while (current != null) {
            System.out.print(current.getData() + (current.getNext() == null ? "\n" : " -> "));
            current = current.getNext();
        }

        // extra test：remove all nodes，make sure final size=0 and head/tail=null
        System.out.println("\n=== make sure list empty ===");
        list.removeFromFront(); // remove 2
        list.removeFromFront(); // remove 3
        list.removeFromFront(); // remove 4
        // list should be empty
        System.out.println("Expected size = 0, actual = " + list.size());
        System.out.println("Head = " + list.getHead());
        System.out.println("Tail = " + list.getTail());

        System.out.println("\n--- Test end ---");
    }
}
