package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q109_ConvertSortedListToBinarySearchTree implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public TreeNode sortedListToBST(ListNode head) {
        int length = lengthOfList(head);
        return buildTree(head, length);
    }

    private TreeNode buildTree(ListNode head, int length) {
        if (0 == length) {
            return null;
        } else if (1 == length) {
            return new TreeNode(head.val);
        }

        ListNode rootListNode = head;
        for (int i = 0; i < length / 2; ++i) {
            rootListNode = rootListNode.next;
        }
        TreeNode root = new TreeNode(rootListNode.val);
        root.left = buildTree(head, (int) Math.ceil((length - 1) / 2.0));
        root.right = buildTree(rootListNode.next, (length - 1) / 2);
        return root;
    }

    private int lengthOfList(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
