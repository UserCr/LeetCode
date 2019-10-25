package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q226_InvertBinaryTree implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);

        root.left = rightTree;
        root.right = leftTree;

        return root;
    }
}
