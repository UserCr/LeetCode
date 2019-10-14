package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q147_InsertionSortList implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public ListNode insertionSortList(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (ListNode curNode = head, preNode = dummy; curNode != null; ) {
            if (preNode == dummy || curNode.val > preNode.val) {
                preNode = preNode.next;
                curNode = curNode.next;
            } else {
                for (ListNode insertPrev = dummy; insertPrev.next != curNode; insertPrev = insertPrev.next) {
                    if (insertPrev.next.val >= curNode.val) {
                        preNode.next = curNode.next;
                        curNode.next = insertPrev.next;
                        insertPrev.next = curNode;
                        break;
                    }
                }
                curNode = preNode.next;
            }
        }

        return dummy.next;
    }
}
