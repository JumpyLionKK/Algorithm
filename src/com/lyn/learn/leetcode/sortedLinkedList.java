/*
Description:
Implement a routine which sorts lists efficiently. It should be a stable sort,i.e., the relative positions of equal elements must remain unchanged.

Example:

Input: [2,3,1,4]

Output: [1,2,3,4]
*/
package com.lyn.learn.leetcode;

public class sortedLinkedList {
    public static ListNode solution (ListNode head) {
        // your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preSlow = new ListNode(0);
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preSlow.next = null;
        return mergeTwoList(solution(head), solution(slow));
    }

    private static ListNode mergeTwoList( ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val){
                cur.next = head2;
                head2 = head2.next;
            }else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }
}
