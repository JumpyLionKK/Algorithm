package com.lyn.learn.binarySearchAndLognAlgorithm;

public class FindKClosetElements {
    public static int[] kClosetElements(int[] A, int target, int k){
        int left = findLowerCloset(A, target);
        int[] results = new int[k];
        int l = left, r = left + 1;
        for(int i = 0; i < k; i++){
            if(isLeftCloser(A, target, l, r)){
                results[i] = A[l];
                l--;
            }else {
                results[i] = A[r];
                r++;
            }
        }
        return results;
    }

    private static boolean isLeftCloser(int[] A, int target, int left, int right){
        if(left < 0){
            return false;
        }
        if(right >= A.length){
            return true;
        }

        if(target - A[left] != A[right] - target){
            return target - A[left] < A[right] - target;
        }
        return true;
    }

    private static int findLowerCloset(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = start +(end - start) / 2;
            if(A[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }

        if(A[end] < target){
            return end;
        }
        if(A[start] < target){
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 4, 6, 8};
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i]);
        }
    }
}
