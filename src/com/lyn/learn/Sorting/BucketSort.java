package com.lyn.learn.Sorting;

public class BucketSort {

    public static void BucketSort(int[] A, int array_size) {
        final int BUCKETS = 10;
        int i, j, k;

        int[] buckets = new int[BUCKETS];
        for (j = 0; j < BUCKETS; j++){
            buckets[j] = 0;
        }

        for (i = 0; i < array_size; i++){
            ++ buckets[A[i]];
        }
        for (i = 0, j = 0; j < BUCKETS;j++){
            for (k = buckets[j];k>0;--k){
                A[i++] = j;
            }
        }
    }

    public static void main(String[] arg) {
        int[] A = {1, 3, 4, 2, 7, 6, 9};
        BucketSort(A, 7);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
    }
}
