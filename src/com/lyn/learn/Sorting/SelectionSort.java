package com.lyn.learn.Sorting;

public class SelectionSort {
    public static void sort(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        for(int i = 0; i < A.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = temp;
        }
    }
    public static void main(String[] arg) {
        int[] A = {1,3,4,2,7,6,9};
        sort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }


    }


}
