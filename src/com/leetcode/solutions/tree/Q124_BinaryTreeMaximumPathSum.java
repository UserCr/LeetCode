package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q124_BinaryTreeMaximumPathSum implements SolutionInterface {
    @Override
    public void run() {
    }

    private int res = Integer.MIN_VALUE;

    //水题。
    public int maxPathSum(TreeNode root) {
        if (null == root) {
            return 0;
        }

        postOrder(root);

        return res;
    }

    private int postOrder(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftValue = postOrder(root.left);
        int rightValue = postOrder(root.right);

        res = Math.max(res, root.val);
        res = Math.max(res, leftValue + root.val);
        res = Math.max(res, rightValue + root.val);
        res = Math.max(res, leftValue + rightValue + root.val);

        return Math.max(root.val, Math.max(leftValue + root.val, rightValue + root.val));
    }
}
