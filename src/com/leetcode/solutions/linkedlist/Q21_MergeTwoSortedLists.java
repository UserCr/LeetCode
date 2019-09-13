package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q21_MergeTwoSortedLists implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        ListNode masterList = l1.val < l2.val ? l1 : l2, slaveList = l1.val >= l2.val ? l1 : l2;
        ListNode prevNode = masterList;
        //Merge slaveList into masterList
        while (slaveList != null) {
            while (prevNode.next != null && prevNode.next.val < slaveList.val) {
                prevNode = prevNode.next;
            }
            if (prevNode.next == null) {
                prevNode.next = slaveList;
                return masterList;
            }
            ListNode temp = prevNode.next;
            prevNode.next = slaveList;
            slaveList = slaveList.next;
            prevNode.next.next = temp;
            prevNode = prevNode.next;
        }
        return masterList;
    }
}
