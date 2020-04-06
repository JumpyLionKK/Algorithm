package com.lyn.learn.leetcode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;
            prev = cur;
            cur = cur.next;
        }

        return dummy.next;
    }


}
