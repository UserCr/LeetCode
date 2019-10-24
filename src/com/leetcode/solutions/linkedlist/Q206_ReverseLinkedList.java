package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q206_ReverseLinkedList implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        for (ListNode cur = head, next; cur != null; cur = next) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }
}
