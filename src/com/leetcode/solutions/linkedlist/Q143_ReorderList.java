package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q143_ReorderList implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = reverseList(slow);
        ListNode curHead = head;
        while (tail != slow) {
            ListNode toMove = tail;
            tail = tail.next;
            toMove.next = curHead.next;
            curHead.next = toMove;
            curHead = toMove.next;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
