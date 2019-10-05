package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q113_PathSumII implements SolutionInterface {
    private interface Algorithm {
        List<List<Integer>> pathSum(TreeNode root, int sum);
    }

    @Override
    public void run() {
    }

    static class Recursion implements Algorithm {
        //水题，思路与"PathSum"解法类似。
        @Override
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new LinkedList<>();
            List<Integer> path = new ArrayList<>();
            postorderTravel(root, sum, path, res);
            return res;
        }

        private void postorderTravel(TreeNode root, int sum, List<Integer> path, List<List<Integer>> finalRes) {
            if (null == root) {
                return;
            }
            path.add(root.val);
            if (sum == root.val && null == root.left && null == root.right) {
                finalRes.add(new LinkedList<>(path));
            } else {
                postorderTravel(root.left, sum - root.val, path, finalRes);
                postorderTravel(root.right, sum - root.val, path, finalRes);
            }
            path.remove(path.size() - 1);
        }
    }

    static class NotRecursion implements Algorithm {
        //水题，思路与"PathSum"解法类似。
        @Override
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new LinkedList<>();
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
                        List<Integer> path = new LinkedList<>();
                        for (TreeNode treeNode : stack) {
                            path.add(treeNode.val);
                        }
                        res.add(path);
                    }

                    stack.pop();
                    preNode = curNode;
                    curNode = null;
                }
            }
            return res;
        }
    }
}
