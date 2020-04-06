/*you are given two non-empty linked list representing two non-negative integers, the digits are sorted in reverse order
and each of thier nodes contains a signle digit, add the two numbers and return it as a linked list
you may assume the two numbers do not contain and leading zero except the numebr 0 itself

corner case: 2 -> 3 -> 4
             8 -> 6 -> 5
        result is 0 -> 0 -> 0 -> 1

Example (2->4->3) + (5->6->7)
        output: 7->0->8
        */
package com.lyn.learn.leetcode;

public class Add_two_numbers {


    public static ListNode addTwoNumber(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null ) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int x = (head1 == null) ? 0 : head1.val;
            int y = (head2 == null) ? 0 : head2.val;
            int sum = x + y + carry;
            head.next = new ListNode(sum % 10);
            carry = sum / 10;
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
            head = head.next;
        }
        if (carry == 1){
            head.next = new ListNode(1);
        }
        return dummy.next;

    }

    public static void main (String[] arg) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(7);
        ListNode result = addTwoNumber(head1, head2);
        while (head1 != null) {
            System.out.println(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            System.out.println(head2.val);
            head2 = head2.next;
        }
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }
}
