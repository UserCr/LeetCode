package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q110_BalancedBinaryTree implements SolutionInterface {
    @Override
    public void run() {
    }

    private class Pair {
        int height;
        boolean isBalanced;

        Pair(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    //水题。
    public boolean isBalanced(TreeNode root) {
        Pair res = isBalance(root);
        return res.isBalanced;
    }

    private Pair isBalance(TreeNode root) {
        if (null == root) {
            return new Pair(0, true);
        }
        Pair left = isBalance(root.left);
        Pair right = isBalance(root.right);
        return new Pair(Math.max(left.height, right.height) + 1,
                left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1);
    }
}
