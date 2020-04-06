package com.lyn.learn.jianzhioffer;

public class CloneRandomListNode {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead){
        cloneNodes(pHead);
        //showNode(pHead);
        connectSiblings(pHead);
        return split(pHead);
        //return pHead;

    }

    public void cloneNodes(RandomListNode pHead){
        if(pHead == null) {
            return;
        }

        while(pHead != null) {
            RandomListNode tempNode = pHead.next;
            RandomListNode newNode = new RandomListNode(pHead.label);
            pHead.next = newNode;
            newNode.next = tempNode;
            pHead = tempNode;
        }



    }

    public void showNode(RandomListNode pHead) {
        while(pHead != null){
            System.out.print(pHead.label);
            pHead = pHead.next;
        }
    }

    public void connectSiblings(RandomListNode pHead){
        if(pHead == null) {
            return;
        }
        while(pHead != null) {
            if(pHead.random != null){
                pHead.next.random = pHead.random.next;
            }

            pHead = pHead.next.next;
        }


    }

    public RandomListNode split(RandomListNode pHead) {
        if(pHead == null) {
            return pHead;
        }
        RandomListNode newHead = pHead.next;
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = newHead;
        while(pHead != null){
            pHead.next = pHead.next.next;
            if(newHead.next != null) {
                newHead.next = newHead.next.next;
            }

            pHead = pHead.next;
            newHead = newHead.next;
        }

        return dummy.next;
    }
}
