package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q148_SortList implements SolutionInterface {
    @Override
    public void run() {
    }

    //链表的O(NlogN)排序算法不常见于一般教材中，实现思路是递归二分。
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode list1 = dummy.next;
        ListNode list2 = slow.next;
        slow.next = null;

        list1 = sortList(list1);
        list2 = sortList(list2);

        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
            tail.next = null;
        }

        if (null == list1) {
            tail.next = list2;
        }
        if (null == list2) {
            tail.next = list1;
        }

        return dummy.next;
    }
}
