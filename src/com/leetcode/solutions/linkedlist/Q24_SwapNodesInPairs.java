package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q24_SwapNodesInPairs implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (ListNode prev = dummy; prev.next != null && prev.next.next != null; prev = prev.next.next) {
            ListNode cur = prev.next, next = prev.next.next;
            cur.next = next.next;
            next.next = cur;
            prev.next = next;
        }
        return dummy.next;
    }
}
