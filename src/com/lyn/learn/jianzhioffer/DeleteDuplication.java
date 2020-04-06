/*
在一个排序的链表中，存在重复的结点，
请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
package com.lyn.learn.jianzhioffer;


import com.lyn.learn.leetcode.ListNode;

public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode prev = dummy;
        while(pHead != null && pHead.next != null){
            if(pHead.val == pHead.next.val){
                while(pHead.next != null && pHead.val == pHead.next.val){
                    pHead = pHead.next;
                }

                pHead = pHead.next;


                prev.next = pHead;
            }else{
                prev = pHead;
                pHead = pHead.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args){

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
    }
}
