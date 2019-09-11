package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q19_RemoveNthNodeFromEndOfList implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，注意题目中的head不是头节点，而是有意义的第一个节点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return head;
        }
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }
        if (null == fast) {
            return head.next;
        } else {
            while (null != fast.next) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        return head;
    }
}
