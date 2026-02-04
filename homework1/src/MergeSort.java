package homework1.src;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {

        int trials = 10;
        long totalTime = 0;
        Random rand = new Random();
        for (int i = 0; i < trials; i++) {
            int[] input = new int[1000];
            for (int j = 0; j < 1000; j++) {
                input[j] = rand.nextInt(5000);
            }
            long start = System.nanoTime();
            mergeSort(input);
            long end = System.nanoTime();
            totalTime += (end - start);
        }
        double avgTime = (totalTime / (double) trials)/1000000;
        System.out.println("Total time: " + avgTime + " ms");
    }


    public static int[] mergeSort(int[] input) {
        //base case: if only left with 1 or 0 input, then return its value
        if (input.length <= 1) {
            return input;
        }
        //recursive case: keep dividing the left and the right parts into smaller parts until each side is only left with 1 or 0 input
        int mid = input.length / 2;
        int[] left = Arrays.copyOfRange(input, 0, mid);
        int[] right = Arrays.copyOfRange(input, mid, input.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }


    // Merges two sorted arrays into one new sorted array
    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0; // index for a
        int j = 0; // index for b
        int k = 0; // index for result


        // Compare elements and add the smaller one
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k] = a[i]; // add val from a if smaller
                i++;
            } else {
                result[k] = b[j]; // add val from b if smaller
                j++;
            }
            k++;
        }


        // Add remaining elements from a (if any)
        while (i < a.length) {
            result[k] = a[i];
            i++;
            k++;
        }

        // Add remaining elements from b (if any)
        while (j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }


        return result;
    }
}
