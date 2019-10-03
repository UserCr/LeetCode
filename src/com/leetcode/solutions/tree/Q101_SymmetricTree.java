package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q101_SymmetricTree implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 水题。题目类似于判断两棵二叉树是否相同。此题同样可以用二叉树非递归遍历来解，解法和判断两棵二叉树是否相同非递归遍历解法类似，
     * 区别就是一棵二叉树是左中右的遍历顺序，一棵二叉树是右中左的遍历顺序。
     */

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right || left.val != right.val) {
            return false;
        }
        return isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }
}
