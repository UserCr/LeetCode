package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q104_MaximumDepthOfBinaryTree implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。非递归方式可以用树的层序遍历来做，也十分简单。
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
