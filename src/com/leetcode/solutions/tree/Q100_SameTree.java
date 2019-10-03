package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q100_SameTree implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。题解用的是递归解法，此题还可以用二叉树非递归遍历来判断，条件是判断空值和val，难度也不大。
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
