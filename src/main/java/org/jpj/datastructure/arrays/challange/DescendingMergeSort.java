package org.jpj.datastructure.arrays.challange;

public class DescendingMergeSort {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] >= input[mid]) { // If last element in the left array is less than first element in the right array,
            // we dont need to compare because the arrays are already sorted.
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }

        /* if there are left over elements in the left array, we directly copy the left over elements from left array to the index after the last index of the
        temp array in the original array. If there are left over elements in the right array, we dont have to do any actions since the right array is
        already sorted. Eg below
        Actual array -> {32, 36, 33, 34}
        Sorted Array -> {32, 33, 34, 36}
        {32, 36}, {33, 34} -> temp array -> {32, 33, 34} now we have 36 which will the leftover in the left array. We need to copy 36 to the start + tempIndex position
        in the input array instead of doing duplicate operation in tempArray.

        Actual array -> {32, 34, 33, 36}
        Sorted Array -> {32, 33, 34, 36}
        {32, 34}, {33, 36} -> temp array {32, 33, 34} now the right array has 36 leftover, but this is already sorted with respsect to the tempArray so its actual position
        in the input array need not be changed.
         */
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);


    }
}
