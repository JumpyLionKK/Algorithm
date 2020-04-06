package com.lyn.learn.Sorting;

public class InsertionSort {
    public static void sort(int[] A) {
        if (A == null || A.length == 0 ){
            return;
        }
        int v,j;
        for(int i = 0; i < A.length; i++) {
            v = A[i];
            j = i;
            while(j > 0 && A[j - 1] > v){
                A[j] = A[j - 1];
                j --;
            }
            A[j] = v;
        }
     }

    public static void main(String[] arg) {
        int[] A = {9,3,4,2,7,6,1};
        sort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }


    }
 }
