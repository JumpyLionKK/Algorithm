package com.lyn.learn.jianzhioffer;

public class Multiply {
    public static int[] multiply(int[] A) {
        if(A == null || A.length == 0){
            return new int[0];
        }

        int[] C = new int[A.length];
        int[] D = new int[A.length];

        C[0] = 1;
        for(int i = 1; i < A.length; i++){
            C[i] = C[i - 1] * A[i - 1];
        }
        D[A.length - 1] = 1;
        for(int j = A.length - 2; j >= 0; j--){
            D[j] = D[j + 1] * A[j + 1];
        }

        int[] B = new int[A.length];
        for(int i = 0; i < A.length; i++){
            B[i] = C[i] * D[i];
        }
        return B;
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4};
        System.out.println(multiply(array));

    }
}
