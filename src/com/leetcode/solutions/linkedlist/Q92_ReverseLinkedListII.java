package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q92_ReverseLinkedListII implements SolutionInterface {
    @Override
    public void run() {
    }

    //链表水题。
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode frontTail = dummy;
        for (int i = 1; i < m; ++i) {
            frontTail = frontTail.next;
        }
        ListNode midTail = frontTail.next, pre = null, cur = frontTail.next;
        for (int i = 0; i < n - m + 1; ++i) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        frontTail.next = pre;
        midTail.next = cur;
        return dummy.next;
    }
}
