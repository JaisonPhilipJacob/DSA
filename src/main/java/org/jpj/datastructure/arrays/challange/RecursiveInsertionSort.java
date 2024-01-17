package org.jpj.datastructure.arrays.challange;

public class RecursiveInsertionSort {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        insertionSort(intArray, 1, intArray.length);
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    //My Solution
    private static void insertionSort(int[] inputArray, int firstUnsortedIndex, int arrayLength) {
        if (firstUnsortedIndex >= arrayLength || firstUnsortedIndex < 1) {
            return;
        }
        int newElement = inputArray[firstUnsortedIndex];
        int i = firstUnsortedIndex;
        while (i >0 && inputArray[i-1] > newElement) {
            inputArray[i] = inputArray[i - 1];
            i--;
        }
        inputArray[i] = newElement;
        insertionSort(inputArray, ++firstUnsortedIndex, arrayLength);
    }

    //Solution From Course
    public static void insertionSort(int[] input, int numItems) {

        if (numItems < 2) {
            return;
        }

        insertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;

        System.out.println("Result of call when numItems = " + numItems);
        for (i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("---------------------");


    }
}
