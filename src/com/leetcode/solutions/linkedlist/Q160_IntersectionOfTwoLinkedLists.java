package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q160_IntersectionOfTwoLinkedLists implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 双链交叉遍历的思路容易记忆，但不要忘记循环终止条件之类的细节，可按照如下方式记忆：
     * 1）若有一个链为空，肯定不相交。
     * 2）记A链有两个结点为1，2，B链有一个结点3，双链不相交。那么双指针遍历顺序分别是：
     * 1，2，null，3，null，1，2，null，3，null，……
     * 3，null，1，2，null，3，null，1，2，null，……
     * 而不是
     * 1，2，3，1，2，3，……
     * 3，1，2，3，1，2，……
     * 否则循环无法终止。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode curNodeA = headA, curNodeB = headB;
        while (curNodeA != curNodeB) {
            curNodeA = curNodeA == null ? headB : curNodeA.next;
            curNodeB = curNodeB == null ? headA : curNodeB.next;
        }
        return curNodeA;
    }
}
