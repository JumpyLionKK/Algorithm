package com.lyn.learn.jianzhioffer;

import com.lyn.learn.leetcode.ListNode;

public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead){

        if(pHead == null){
            return null;
        }

        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while(fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = pHead;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
