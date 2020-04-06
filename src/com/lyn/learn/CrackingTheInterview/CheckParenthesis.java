/*
对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。

给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串
 */
package com.lyn.learn.CrackingTheInterview;

import java.util.Stack;

public class CheckParenthesis {

    public boolean checkParenthesis(String A, int n){
        Stack<Character> stack = new Stack<>();

        char[] array = A.toCharArray();
        for(int i = 0; i < array.length; i++){
            if(array[i] == '('){
                stack.push(array[i]);
            }else if(array[i] != '(' && array[i] != ')'){
                continue;
            }else if(array[i] == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
