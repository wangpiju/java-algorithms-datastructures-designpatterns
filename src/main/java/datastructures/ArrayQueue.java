package datastructures;

import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayQueue.
 */
public class ArrayQueue<T> {

    /*
     * The initial capacity of the ArrayQueue.
     *
     * DO NOT MODIFY THIS VARIABLE.
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayQueue.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        if (size == backingArray.length) {
            resize();
        }

        int back = (front + size) % backingArray.length;
        backingArray[back] = data;
        size++;
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Do not shrink the backing array.
     *
     * Replace any spots that you dequeue from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        T data = backingArray[front];
        backingArray[front] = null;
        front = (front + 1) % backingArray.length;
        size--;

        return data;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[backingArray.length * 2];

        for (int i = 0; i < size; i++) {
            newArray[i] = backingArray[(front + i) % backingArray.length];
        }

        backingArray = newArray;
        front = 0;
    }

    /**
     * Returns the backing array of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the queue
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        // Enqueue elements
        for (int i = 1; i <= 12; i++) {
            queue.enqueue(i);
            System.out.println("Enqueued: " + i);
        }

        System.out.println("Queue size after enqueues: " + queue.size());

        // Dequeue some elements
        for (int i = 1; i <= 5; i++) {
            int dequeued = queue.dequeue();
            System.out.println("Dequeued: " + dequeued);
        }

        System.out.println("Queue size after dequeues: " + queue.size());

        // Enqueue again to test wraparound
        for (int i = 13; i <= 16; i++) {
            queue.enqueue(i);
            System.out.println("Enqueued: " + i);
        }

        System.out.println("Final Queue:");
        Object[] backing = queue.getBackingArray();
        for (int i = 0; i < backing.length; i++) {
            System.out.println("Index " + i + ": " + backing[i]);
        }
    }
}
