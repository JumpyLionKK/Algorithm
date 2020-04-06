package com.lyn.learn.CrackingTheInterview;


import com.lyn.learn.leetcode.ListNode;

public class PlusAB {

    public static ListNode plusAB(ListNode a, ListNode b){


        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carryBit = 0;
        while(a != null || b != null || carryBit != 0){
            ListNode node = new ListNode(carryBit);
            cur.next = node;
            if(a != null){
                node.val += a.val;
                a = a.next;
            }

            if(b != null){
                node.val += b.val;
                b = b.next;
            }

            if(node.val > 9){
                node.val = node.val - 10;
                carryBit = 1;
            }else{
                carryBit = 0;
            }
            cur = cur.next;
        }
        return dummy.next;


    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(9);
        b.next = new ListNode(2);
        ListNode res = plusAB(a, b);
        while(res != null){
            System.out.print(res.val);
            res = res.next;
        }

    }
}
