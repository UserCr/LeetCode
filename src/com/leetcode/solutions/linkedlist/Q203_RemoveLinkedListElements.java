package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q203_RemoveLinkedListElements implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (ListNode preNode = dummy; preNode != null && preNode.next != null; preNode = preNode.next) {
            while (preNode.next != null && preNode.next.val == val) {
                preNode.next = preNode.next.next;
            }
        }
        return dummy.next;
    }
}
