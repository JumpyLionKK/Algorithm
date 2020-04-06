package com.lyn.learn.jianzhioffer;


import java.util.Set;
import java.util.Stack;

public class isPopOrder {
    public boolean IspopOrder(int[] pushA, int[] popA){

        Stack<Integer> stack = new Stack<>();

        for(int i = 0, j = 0; i < pushA.length;){
            stack.push(pushA[i ++]);
            while(j < popA.length && stack.peek() == popA[j]){
                stack.pop();
                j ++;
            }
        }


        return stack.empty();



    }
}
