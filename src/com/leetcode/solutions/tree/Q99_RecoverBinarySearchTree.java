package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q99_RecoverBinarySearchTree implements SolutionInterface {
    @Override
    public void run() {
    }

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    /***
     * 此题看上去很难，但其实这是个水题，难点在于读懂题意。
     * 题目中只有两个结点的值被错误交换过，按二叉搜索树中序遍历必须递增的性质就可以轻松找到，再交换这两个值就是解。
     */
    public void recoverTree(TreeNode root) {
        inorder(root);

        if (null != first && null != second) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode root) {
        if (null == root) {
            return;
        }

        inorder(root.left);

        if (null != prev && null == first && prev.val > root.val) {
            first = prev;
        }
        if (null != prev && null != first && prev.val > root.val) {
            second = root;
        }

        prev = root;

        inorder(root.right);
    }
}
