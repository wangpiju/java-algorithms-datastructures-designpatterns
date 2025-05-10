package algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = { 5, 2, 9, 1, 5, 6 };
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));

        int[] array2 = { 5, 2, 9, 1, 5, 6 };
        // Recursive QuickSort implementation
        recursiveQuickSort(array2, 0, array2.length - 1);
        System.out.println("Sorted array (recursive): " + Arrays.toString(array2));

    }

    private static void quickSort(int[] array, int low, int high) {
        if (low >= high)
            return;
        int pivot = array[low + (high - low) / 2];
        int i = low, j = high;

        while (i <= j) {
            // Move left pointer until element >= pivot
            while (array[i] < pivot)
                i++;
            // Move right pointer until element <= pivot
            while (array[j] > pivot)
                j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // Recursively sort left and right partitions
        if (low < j)
            quickSort(array, low, j);
        if (i < high)
            quickSort(array, i, high);

    }

    // Recursive QuickSort implementation
    private static void recursiveQuickSort(int[] array, int low, int high) {
        if (low >= high)
            return;

        // Partition the array and get the pivot index
        int pivotIndex = partition(array, low, high);

        // Recursively sort the left and right partitions
        recursiveQuickSort(array, low, pivotIndex - 1);
        recursiveQuickSort(array, pivotIndex + 1, high);
    }

    // Partition method for recursive QuickSort
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Use the last element as the pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Place the pivot in its correct position
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Return the pivot index
    }

}
