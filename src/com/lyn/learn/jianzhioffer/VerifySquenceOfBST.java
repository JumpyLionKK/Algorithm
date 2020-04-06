package com.lyn.learn.jianzhioffer;

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        return helper(sequence, 0, sequence.length - 1);
    }

    public boolean helper(int[] sequence, int start, int end){
        if(sequence == null || end - start + 1 <= 0){
            return false;
        }
        int length = end - start;
        int root = sequence[end];
        int i = 0;
        for(; i < length - 1; i++){
            if(sequence[i] > root){
                break;
            }
        }
        int j = i;
        for(; j < length - 1; j++){
            if(sequence[j] < root){
                return false;
            }
        }
        boolean left = true;
        if(i > 0){
            left = helper(sequence, 0, i - 1);
        }

        boolean right = true;
        if(j < length) {
            right = helper(sequence, i, end - 1);
        }

        return left && right;
    }

}
