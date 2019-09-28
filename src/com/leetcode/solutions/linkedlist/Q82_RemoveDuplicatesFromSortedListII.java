package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q82_RemoveDuplicatesFromSortedListII implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，稍有难度。
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (ListNode pre = dummy, cur; null != pre && null != pre.next; pre = pre.next) {
            cur = pre.next;
            while (cur != null && cur.next != null && cur.next.val == cur.val) {
                ListNode deleteNode = cur;
                while (cur != null && cur.val == deleteNode.val) {
                    cur = cur.next;
                }
            }
            pre.next = cur;
        }
        return dummy.next;
    }
}
