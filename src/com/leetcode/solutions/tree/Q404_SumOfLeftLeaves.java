package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.Stack;

public class Q404_SumOfLeftLeaves implements SolutionInterface {
    interface Algorithm {
        int sumOfLeftLeaves(TreeNode root);
    }

    @Override
    public void run() {
    }

    static class Recursive implements Algorithm {
        //水题。
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int res = 0;
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    res += root.left.val;
                } else {
                    res += sumOfLeftLeaves(root.left);
                }
            }
            res += sumOfLeftLeaves(root.right);
            return res;
        }
    }

    static class Iterative implements Algorithm {
        //水题。
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            if (null == root || null == root.left && null == root.right) {
                return 0;
            }

            int res = 0;
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || null != root) {
                while (root != null) {
                    if (root.left == null && root.right == null) {
                        res += root.val;
                    }
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
                //右叶子结点直接丢弃
                if (null != root && null == root.left && null == root.right) {
                    root = null;
                }
            }
            return res;
        }
    }
}
