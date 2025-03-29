package algorithms;

public class InsertionSort {
    public static void insertionSort(char[] data) {
        int n = data.length;

        for (int k = 1; k < n; k++) {
            char current = data[k];
            int j = k;

            while (j > 0 && data[j - 1] > current) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = current;
        }
    }

    /** Returns a string representation of the array */
    public static String toString(char[] data) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(data[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test case 1: unsorted array
        char[] test1 = { 'B', 'C', 'D', 'A', 'E' };
        System.out.println("Before sorting: " + toString(test1));
        insertionSort(test1);
        System.out.println("After sorting:  " + toString(test1));

        // Test case 2: already sorted array
        char[] test2 = { 'A', 'B', 'C', 'D', 'E' };
        System.out.println("\nBefore sorting: " + toString(test2));
        insertionSort(test2);
        System.out.println("After sorting:  " + toString(test2));

        // Test case 3: reverse sorted array
        char[] test3 = { 'E', 'D', 'C', 'B', 'A' };
        System.out.println("\nBefore sorting: " + toString(test3));
        insertionSort(test3);
        System.out.println("After sorting:  " + toString(test3));
    }
}

/*
 * Time Complexity Analysis:
 * - Best Case: O(n) when array is already sorted
 * - Average Case: O(n^2) when array is randomly ordered
 * - Worst Case: O(n^2) when array is reverse sorted
 * 
 * Space Complexity Analysis:
 * - O(1) as it sorts in-place, only using a constant amount of extra space
 * - Only requires one additional variable (current) for swapping
 * 
 * Characteristics:
 * - Stable sorting algorithm
 * - In-place algorithm
 * - Adaptive: performance improves if array is partially sorted
 * - Efficient for small data sets
 * - More efficient in practice than bubble sort and selection sort
 */
