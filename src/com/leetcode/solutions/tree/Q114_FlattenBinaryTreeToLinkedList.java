package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q114_FlattenBinaryTreeToLinkedList implements SolutionInterface {
    private interface Algorithm {
        void flatten(TreeNode root);
    }

    @Override
    public void run() {
    }

    static class Recursion implements Algorithm {
        //水题。
        @Override
        public void flatten(TreeNode root) {
            if (null == root || null == root.left && null == root.right) {
                return;
            }

            flatten(root.left);
            flatten(root.right);

            if (root.left != null) {
                TreeNode tail = root.left;
                while (tail.right != null) {
                    tail = tail.right;
                }
                tail.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
    }

    static class Iteration implements Algorithm {
        /***
         * 迭代方法稍有难度。思路是把左儿子一路向右的一层与右儿子拼接。因为拼接后右儿子已经替换为了左儿子，所以不会遗漏任何结点。
         */
        @Override
        public void flatten(TreeNode root) {
            TreeNode curNode = root;
            while (curNode != null) {
                TreeNode toMove = curNode.left;
                if (toMove != null) {
                    TreeNode originRightSubTree = curNode.right;
                    curNode.right = toMove;
                    while (toMove.right != null) {
                        toMove = toMove.right;
                    }
                    toMove.right = originRightSubTree;
                    curNode.left = null;
                }
                curNode = curNode.right;
            }
        }
    }
}
