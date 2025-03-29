package basic_tools;

import java.util.Arrays;

public class ArraysTools {
    public static void main(String[] args) {
        // Test Arrays.equals()
        int[] array1 = { 1, 2, 3, 4, 5 };
        int[] array2 = { 1, 2, 3, 4, 5 };
        int[] array3 = { 1, 2, 3, 5, 4 };
        System.out.println("Testing equals():");
        System.out.println("array1 equals array2: " + Arrays.equals(array1, array2)); // true
        System.out.println("array1 equals array3: " + Arrays.equals(array1, array3)); // false
        System.out.println();

        // Test Arrays.fill()
        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 10);
        System.out.println("Testing fill():");
        System.out.println("Filled array: " + Arrays.toString(fillArray)); // [10, 10, 10, 10, 10]
        System.out.println();

        // Test Arrays.copyOf()
        int[] original = { 1, 2, 3, 4, 5 };
        int[] copied = Arrays.copyOf(original, 7); // Copies and extends length to 7
        System.out.println("Testing copyOf():");
        System.out.println("Original array: " + Arrays.toString(original));
        System.out.println("Copied array: " + Arrays.toString(copied)); // [1, 2, 3, 4, 5, 0, 0]
        System.out.println();

        // Test Arrays.copyOfRange()
        int[] rangeArray = Arrays.copyOfRange(original, 1, 4); // Copy elements from index 1 to 3
        System.out.println("Testing copyOfRange():");
        System.out.println("Range copied array: " + Arrays.toString(rangeArray)); // [2, 3, 4]
        System.out.println();

        // Test Arrays.toString()
        System.out.println("Testing toString():");
        System.out.println("Array as string: " + Arrays.toString(original)); // [1, 2, 3, 4, 5]
        System.out.println();

        // Test Arrays.sort()
        int[] unsorted = { 5, 2, 8, 1, 9 };
        Arrays.sort(unsorted);
        System.out.println("Testing sort():");
        System.out.println("Sorted array: " + Arrays.toString(unsorted)); // [1, 2, 5, 8, 9]
        System.out.println();

        // Test Arrays.binarySearch()
        int searchKey = 5;
        int index = Arrays.binarySearch(unsorted, searchKey);
        System.out.println("Testing binarySearch():");
        System.out.println("Found " + searchKey + " at index: " + index); // 2
        System.out.println();
    }
}

/*
 * Common Array Methods in Java (java.util.Arrays):
 * 
 * 1. equals(array1, array2)
 * - Compares two arrays for equality
 * - Returns true if arrays have same length and elements
 * - Time Complexity: O(n)
 * 
 * 2. fill(array, value)
 * - Fills entire array with specified value
 * - Useful for array initialization
 * - Time Complexity: O(n)
 * 
 * 3. copyOf(original, newLength)
 * - Creates new array copying elements from original
 * - Can specify new length (truncate or pad with zeros)
 * - Time Complexity: O(n)
 * 
 * 4. copyOfRange(original, from, to)
 * - Copies specified range of original array
 * - Range is [from, to), 'to' index is exclusive
 * - Time Complexity: O(n)
 * 
 * 5. toString(array)
 * - Converts array to string representation
 * - Returns format: "[elem1, elem2, ...]"
 * - Time Complexity: O(n)
 * 
 * 6. sort(array)
 * - Sorts array in ascending order
 * - Uses modified quicksort for primitives
 * - Time Complexity: O(n log n)
 * 
 * 7. binarySearch(array, key)
 * - Searches for key in sorted array
 * - Returns index if found, negative value if not found
 * - Time Complexity: O(log n)
 * - Requires array to be sorted first
 */
