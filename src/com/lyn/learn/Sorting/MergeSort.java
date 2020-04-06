package com.lyn.learn.Sorting;

public class MergeSort {
    public static void sort(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(A, left, mid);
        sort(A, mid + 1, right);
        merge(A, left, right);
    }

    private static void merge(int[] A, int left, int right) {
        int mid = left + (right - left) / 2;
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        for (int k = 0; k < right - left + 1; k++) {
            if(i <= mid && ((j > right) || A[i] < A[j] )) {
                temp[k] = A[i++];
            } else {
                temp[k] = A[j++];
            }
        }
        for (int k = 0; k < right - left + 1; k ++) {
            A[left + k] = temp[k];
        }
    }
    public static void main(String[] arg) {
        int[] A = {5,5,5,4,3,2,7,8,7,3,1};
        sort(A, 0, A.length - 1);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }

}
    }
