package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q61_RotateList implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public ListNode rotateRight(ListNode head, int k) {
        ListNode oldTail = head;
        int length = 0;
        for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
            length++;
            if (oldTail.next != null) {
                oldTail = oldTail.next;
            }
        }

        if (0 == length || 0 == k % length) {
            return head;
        }

        k %= length;

        ListNode newHead = head, newTail = head;
        for (int i = 0; i < length - k; i++) {
            newHead = newHead.next;
            if (0 != i) {
                newTail = newTail.next;
            }
        }
        newTail.next = null;
        oldTail.next = head;
        return newHead;
    }
}
