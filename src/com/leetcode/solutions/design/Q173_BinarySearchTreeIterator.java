package com.leetcode.solutions.design;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.Stack;

public class Q173_BinarySearchTreeIterator implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    class BSTIterator {
        private TreeNode curNode;
        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            curNode = root;
            stack = new Stack<>();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();

            int res = curNode.val;

            curNode = curNode.right;
            return res;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty() || curNode != null;
        }
    }
}
