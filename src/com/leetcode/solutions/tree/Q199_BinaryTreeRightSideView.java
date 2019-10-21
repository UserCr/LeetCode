package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_BinaryTreeRightSideView implements SolutionInterface {
    interface Algorithm {
        List<Integer> rightSideView(TreeNode root);
    }

    @Override
    public void run() {
    }

    static class LevelTraversal implements Algorithm {
        //水题。
        @Override
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            if (null == root) {
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                if (queue.peek() == null) {
                    res.add(curNode.val);
                    queue.poll();
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                }
            }
            return res;
        }
    }

    static class Recursion implements Algorithm {
        //递归写法，何时更新答案List有一定难度。
        @Override
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            backTracking(root, res, 0);
            return res;
        }

        private void backTracking(TreeNode root, List<Integer> res, int level) {
            if (null == root) {
                return;
            }
            if (res.size() == level) {
                res.add(root.val);
            }
            backTracking(root.right, res, level + 1);
            backTracking(root.left, res, level + 1);
        }
    }
}
