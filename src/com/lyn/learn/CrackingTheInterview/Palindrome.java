package com.lyn.learn.CrackingTheInterview;


import com.lyn.learn.leetcode.ListNode;

public class Palindrome {

    public boolean isPalindrome(ListNode pHead) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;

        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next == null){
            slow = slow.next;
        }
        ListNode reversedHead = reverseLinkedList(slow);
        while(pHead != null && reversedHead != null){
            if(pHead.val != reversedHead.val){
                return false;
            }
            pHead = pHead.next;
            reversedHead = reversedHead.next;
        }
        return true;


    }

    public ListNode reverseLinkedList(ListNode pHead){

        if(pHead == null){
            return null;
        }
        if(pHead.next == null){
            return pHead;
        }
        ListNode newHead = reverseLinkedList(pHead.next);
        pHead.next.next = pHead;
        pHead.next = null;

        return newHead;
    }
}
