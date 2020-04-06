package com.lyn.learn.Sorting;

public class QuickSort {
    public static void sort(int[] A, int left, int right) {
        if(left >= right) {
            return;
        }

        int start = left;
        int end = right;

        int pivot = A[start + (end - start) /2];

        while(start <= end) {
            while(start <= end && A[start] < pivot) {
                start ++;
            }
            while(start <= end && A[end] > pivot) {
                end --;
            }

            if(start <= end) {
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;

                start ++;
                end --;
            }
        }

        sort(A, left, end);
        sort(A, start, right);
    }

    public static void main(String[] arg) {
        int[] A = {1, 3, 4, 2, 7, 6, 9};
        sort(A, 0, A.length - 1);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
    }
}
