/*
请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。

给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，
请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到最后一个元素。

测试样例：
 */
package com.lyn.learn.CrackingTheInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoStacksSort {

    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        Stack<Integer> initStack = new Stack<>();
        for(int i = 0; i < numbers.length;i++){
            initStack.push(numbers[i]);
        }
        Stack<Integer> tempStack = new Stack<>();

        while(!initStack.isEmpty()){
            if(tempStack.isEmpty()){
                tempStack.push(initStack.pop());
            }else{
                if(tempStack.peek() <= initStack.peek()){
                    tempStack.push(initStack.pop());
                }else{
                    int temp = initStack.pop();
                    while(!tempStack.isEmpty() && tempStack.peek() > temp){
                        initStack.push(tempStack.pop());
                    }
                    tempStack.push(temp);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!tempStack.isEmpty()){
            res.add(tempStack.pop());
        }
        return res;

    }
}
