package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q111_MinimumDepthOfBinaryTree implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。注意只有一个儿子的结点最小高度不是1，而是其子树的最小高度+1。层序遍历也可以做，第一次发现叶子时立刻返回当前层数。
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left) {
            return minDepth(root.right) + 1;
        } else if (null == root.right) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
