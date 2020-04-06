/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
package com.lyn.learn.jianzhioffer;

import java.util.*;

public class FirstAppearingOnce {

    Deque<Character> deque = new ArrayDeque<>();
    char str;


    public void Insert(char ch){
        if (deque.isEmpty()){
            str = ch;
            deque.add(ch);
        }else{
            if(ch == deque.peekLast()){
                deque.pollLast();
            }else if(ch == deque.peekFirst()){
                deque.pollFirst();
            }else{
                deque.addLast(ch);
            }
        }
        if(deque.isEmpty()){
            str = '#';
        }else{
            str = deque.getFirst();
        }


    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        return str;
    }
}
