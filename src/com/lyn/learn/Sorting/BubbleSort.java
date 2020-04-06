package com.lyn.learn.Sorting;

public class BubbleSort {
    public static void sort(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        for(int pass = A.length - 1; pass >= 0; pass --) {
            for (int i = 0; i < pass; i++) {
                if (A[i] > A[i + 1]){
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }
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
