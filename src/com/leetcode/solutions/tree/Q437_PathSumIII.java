package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q437_PathSumIII implements SolutionInterface {
    @Override
    public void run() {
    }

    //稍有难度的水题。
    public int pathSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode treeNode, int sum) {
        if (null == treeNode) {
            return 0;
        }
        return (sum == treeNode.val ? 1 : 0) + pathSumFrom(treeNode.left, sum - treeNode.val) +
                pathSumFrom(treeNode.right, sum - treeNode.val);
    }
}
