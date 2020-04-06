/*
0,1...,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字，
求出这个圆环里最后一个数字
 */
package com.lyn.learn.jianzhioffer;

import java.util.LinkedList;

public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < n; i++){
            linkedList.add(i);
        }
        int hit = 0;
        while(linkedList.size() > 1){
            // 第一次删掉的位置是从0开始数m-1个位置，以后每次从删掉的下一个节点开始取，
            // 所以每次要在bt的索引处加上m-1，因为是环，所以加了以后对链表长度取余
            hit = (hit + m - 1) % linkedList.size();
            linkedList.remove(hit);
        }
        return linkedList.size() == 1 ? linkedList.get(0) : -1;
    }
}
