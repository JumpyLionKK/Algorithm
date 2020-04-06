/*
请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。

给定一个操作序列int[][2] ope(C++为vector&ltvector&ltint>>)，每个操作的第一个数代表操作类型，若为1，则为push操作，后一个数为应push的数字；
若为2，则为pop操作，后一个数无意义。请返回一个int[][](C++为vector&ltvector&ltint>>)，
为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 */
package com.lyn.learn.CrackingTheInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class SetOfStack {

    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curList = new ArrayList<>();
        res.add(curList);
        for(int i = 0; i < ope.length; i++){
            switch (ope[i][0]){
                case 1:
                    if(curList.size() < size){
                        curList.add(ope[i][1]);
                    }else if(curList.size() == size){
                        curList = new ArrayList<Integer>();
                        res.add(curList);
                        curList.add(ope[i][1]);
                    }
                    break;
                case 2:
                    if(curList.size() != 0){
                        curList.remove(curList.size() - 1);
                    }else{
                        res.remove(res.size() - 1);
                        curList = res.get(res.size() - 1);
                        curList.remove(curList.size() - 1);
                    }
                    break;


            }
        }
        return res;

    }
}
