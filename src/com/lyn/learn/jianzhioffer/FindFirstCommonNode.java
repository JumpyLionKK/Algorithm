/*
输入两个链表，找出它们的第一个公共结点。
1. 将其中一个链表头尾相连
2. 找出环的起始点
 */
package com.lyn.learn.jianzhioffer;


import com.lyn.learn.leetcode.ListNode;

public class FindFirstCommonNode {
    // 方法一，复杂度过高系统不认
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2){
        // 1. connect pHead2's head and tail.If two listnode have intersection, we will be creating a listnode
        // a circle.
        ListNode dummy2 = new ListNode(0);
        dummy2.next = pHead2;
        while(pHead2.next != null){
            pHead2 = pHead2.next;
            //System.out.println(pHead2.val);
        }
        pHead2.next = dummy2.next;
        // 2. set fast and slow pointer to find the meeting point
        ListNode dummy1 = new ListNode(0);
        dummy1.next = pHead1;
        ListNode fast = pHead1;
        ListNode slow = pHead1;
        while(fast.next != null){
            fast = fast.next.next;
            //System.out.println(fast.val);
            slow = slow.next;
            //System.out.println(slow.val);
            if(fast == slow){
                break;
            }
        }
        // 3. now we are at the meeting point, reset fast to the head and keep slow fixed
        fast = dummy1.next;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
    public ListNode findFirstCommonListNode2(ListNode pHead1, ListNode pHead2){
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        dummy1.next = pHead1;
        dummy2.next = pHead2;
        int count = 0;
        while(pHead1 != null && pHead2 != null){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
            count ++;
        }
        int diff = 0;
        boolean isPHead1Longer = false;

        if(pHead1 != null){
            isPHead1Longer = true;
            while(pHead1 != null){
                pHead1 = pHead1.next;
                diff++;
            }
        }else{
            while(pHead2 != null){
                pHead2 = pHead2.next;
                diff++;
            }
        }
        pHead1 = dummy1.next;
        pHead2 = dummy2.next;
        if(isPHead1Longer){
            while(diff > 0){
                pHead1 = pHead1.next;
                diff--;
            }
        }else{
            while(diff > 0){
                pHead2 = pHead2.next;
                diff--;
            }
        }

        while(pHead1 != null && pHead2 != null){
            if(pHead1 == pHead2){
                break;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;

        }
        return pHead2;

    }

    public static void main(String[] args){
        //head1
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(2);

        //head2
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(5);
        ListNode p7 = new ListNode(7);
        ListNode p8 = new ListNode(8);
        p1.next = p2;
        p2.next = p3;
        p4.next = p6;
        //p5.next = p6;
        p3.next = p7;
        p6.next = p7;
        p7.next = p8;

        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();
        //findFirstCommonNode.findFirstCommonNode(p1,p4);
        System.out.println(findFirstCommonNode.findFirstCommonListNode2(p1,p4).val);


    }
}
