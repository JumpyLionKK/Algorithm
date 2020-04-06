/*
Description
Write a program which takes an input of two sorted arrays,
and returns a new array containing elements that are present in both of the input arrays.
The input array may have duplicate entries, but the returned array should be free of duplicates.

Example:

Input: [2,3,3,5,5,6,7,7,8,12], [5,5,6,8,8,9,10,10]

Output: [5,6,8]
*/
package com.lyn.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class computeIntersctionOfTwoSortedArray {
    public static List<Integer> solution(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        ArrayList<Integer> lis = new ArrayList<>();
        while (i < A.length && j < B.length) {
            if (A[i] == B[j] && (i == 1 || A[i] != A[i - 1])) {
                lis.add(A[i]);
                i ++;
                j ++;
            } else if (A[i] < B[j]) {
                i ++;
            } else {
                j ++;
            }
        }
        return lis;
    }
}
