package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q83_RemoveDuplicatesFromSortedList implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (ListNode pre = dummy, cur; pre.next != null; pre = pre.next) {
            cur = pre.next;
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            pre.next = cur;
        }
        return dummy.next;
    }
}
