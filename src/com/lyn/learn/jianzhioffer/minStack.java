package com.lyn.learn.jianzhioffer;

import java.util.Stack;

public class minStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();



    public void push(int node) {
        if(stack2.empty()){
            stack2.push(node);
        }else {
            if(node < stack2.peek()){
                stack2.push(node);
            }else{
                stack2.push(stack2.peek());
            }
        }
        stack1.push(node);


    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args){
        minStack stack = new minStack();
        stack.push(3);
    }
}
