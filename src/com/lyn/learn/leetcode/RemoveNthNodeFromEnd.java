package com.lyn.learn.leetcode;

public class RemoveNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode subHead = head;
        ListNode subTail = head;
        int count = n;
        while(count > 1){
            if(subTail.next == null && count > 2){
                return null;
            }
            subTail = subTail.next;

            count--;
        }
        ListNode subPrevHead = dummy;
        while(subTail.next != null){
            subPrevHead = subHead;
            subHead = subHead.next;
            subTail = subTail.next;
        }
        subPrevHead.next = subHead.next;
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        removeNthFromEnd(head, 1);
    }
}
