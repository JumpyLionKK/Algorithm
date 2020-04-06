package com.lyn.learn.jianzhioffer;

public class InversePairs {
    private static int N = 1000000007;

    private int inversePairs;

    public int InversePairs(int [] array) {
        if(array == null || array.length <= 1)
            return 0;
        inversePairs = 0;
        mergeSort(array);
        return inversePairs;
    }

    private void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        mergeSort(array, 0, array.length - 1, tmp);
    }

    private void mergeSort(int[] array, int low, int high, int[] tmp) {
        if(low >= high)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid, tmp);
        mergeSort(array, mid + 1, high, tmp);
        merge(array, low, mid, high, tmp);
    }

    private void merge(int[] array, int low, int mid, int high, int[] tmp) {
        int i = mid;
        int j = high;
        int pairs = high - mid;
        for(int k = low; k <= high; ++k)
            tmp[k] = array[k];
        for(int k = high; k >= low; --k) {
            if(i < low) {
                array[k] = tmp[j--];
            }
            else if(j < mid + 1) {
                array[k] = tmp[i--];
            }
            else if(tmp[i] > tmp[j]) {
                array[k] = tmp[i--];
                inversePairs = (inversePairs + pairs) % N;
            }
            else {
                array[k] = tmp[j--];
                --pairs;
            }
        }
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,0};
        InversePairs inversePairs = new InversePairs();
        System.out.println(inversePairs.InversePairs(array));
    }
}
