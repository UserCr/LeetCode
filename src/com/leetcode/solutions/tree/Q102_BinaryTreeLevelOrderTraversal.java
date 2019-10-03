package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102_BinaryTreeLevelOrderTraversal implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。注意判断空值输入。
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (null == root) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            while (null != queue.peek()) {
                TreeNode curNode = queue.poll();
                curLevel.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            res.add(curLevel);
            queue.poll();
            if (!queue.isEmpty()) {
                queue.add(null);
            }
        }
        return res;
    }
}
