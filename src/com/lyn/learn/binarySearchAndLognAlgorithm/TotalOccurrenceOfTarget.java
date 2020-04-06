package com.lyn.learn.binarySearchAndLognAlgorithm;

public class TotalOccurrenceOfTarget {
    public static int totalOccurrence(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }

        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        int startIndex = start;
        if(A[end] < target) {
            return 0;
        }
        if(A[start] < target){
            startIndex = end;
        }
        //System.out.print(startIndex);
        int count = 0;
        while( startIndex < A.length && A[startIndex] == target){
            count++;
            startIndex++;
        }
        return count;
    }
}
