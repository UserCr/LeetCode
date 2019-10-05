package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.Stack;

public class Q112_PathSum implements SolutionInterface {
    private interface Algorithm {
        boolean hasPathSum(TreeNode root, int sum);
    }

    @Override
    public void run() {
    }

    static class Recursion implements Algorithm {
        //水题。注意必须是根到叶子的路径，根到中间节点的路径不算。
        @Override
        public boolean hasPathSum(TreeNode root, int sum) {
            if (null == root) {
                return false;
            } else if (sum == root.val && null == root.left && null == root.right) {
                return true;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    static class NotRecursion implements Algorithm {
        /***
         * 二叉树后序非递归遍历，必须掌握。后序非递归遍历有很多种写法，题解这种是最接近前序中序经典非递归写法的，必须记住。
         */
        @Override
        public boolean hasPathSum(TreeNode root, int sum) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curNode = root, preNode = null;
            int curSum = sum;
            while (!stack.isEmpty() || null != curNode) {
                while (null != curNode) {
                    curSum -= curNode.val;

                    stack.push(curNode);
                    curNode = curNode.left;
                }
                curNode = stack.peek();
                if (curNode.right != null && preNode != curNode.right) {
                    curNode = curNode.right;
                } else {
                    curSum += curNode.val;
                    if (null == curNode.left && null == curNode.right && curSum == curNode.val) {
                        return true;
                    }

                    stack.pop();
                    preNode = curNode;
                    curNode = null;
                }
            }
            return false;
        }
    }
}
