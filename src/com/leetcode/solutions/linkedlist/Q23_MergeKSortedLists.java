package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23_MergeKSortedLists implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。方法众多，最简单且效率高的就是优先队列法（需要复习一下堆）。效率比较高的还有两两归并排序。
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || 0 == lists.length) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }

        while (!priorityQueue.isEmpty()) {
            tail.next = priorityQueue.poll();
            tail = tail.next;
            if (tail.next != null) {
                priorityQueue.add(tail.next);
            }
        }
        return dummy.next;
    }
}
