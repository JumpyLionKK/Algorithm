/*
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
{2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
package com.lyn.learn.jianzhioffer;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SlideWindow {

    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < size - 1; i++){
            while(!deque.isEmpty() && num[i] > num[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        for(int i = size - 1; i < num.length; i++){
            while(!deque.isEmpty() && num[i] > num[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(i - deque.getFirst() + 1 > size){
                deque.pollFirst();
            }
            res.add(num[deque.getFirst()]);
        }
        return res;

    }

    public static void main(String[] args){
        int[] array = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> res = maxInWindows(array, 3);
        for(Integer c:res){
            System.out.println(c);
        }
    }
}
