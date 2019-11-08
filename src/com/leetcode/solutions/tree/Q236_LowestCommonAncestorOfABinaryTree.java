package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q236_LowestCommonAncestorOfABinaryTree implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (null != left && null != right) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }
}
