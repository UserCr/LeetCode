package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q230_KthSmallestElementInABST implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int kthSmallest(TreeNode root, int k) {
        int leftNum = treeNodeNum(root.left);
        if (k == leftNum + 1) {
            return root.val;
        } else if (k <= leftNum) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - 1 - leftNum);
        }
    }

    private int treeNodeNum(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + treeNodeNum(root.left) + treeNodeNum(root.right);
    }
}
