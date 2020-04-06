package com.lyn.learn.leetcode;

public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists ){

        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode initialListNode = lists[0];

        for(int i = 1; i < lists.length; i++){
            initialListNode = mergeTwo(initialListNode, lists[i]);
        }

        return initialListNode;

    }

    public static ListNode mergeTwo(ListNode pHead1, ListNode pHead2){

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;


        while(pHead1 != null || pHead2 != null){


            if(pHead2 == null ||  (pHead1 != null && pHead1.val < pHead2.val)){
                cur.next = pHead1;
                pHead1 = pHead1.next;
            }else if(pHead1 == null || (pHead2 != null && pHead1.val >= pHead2.val)){
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            cur = cur.next;
        }
        return dummy.next;

    }

    public static void main(String[] args){


        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);
        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);
        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);
        ListNode[] lists = {n1, n2, n3};
        mergeKLists(lists);


    }

}
