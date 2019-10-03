package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.*;

public class Q103_BinaryTreeZigzagLevelOrderTraversal implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。注意只要将输出的结果逆转就行，不要在遍历的部分做逆转。
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (null == root) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean isReverse = false;

        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
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

            if (isReverse) {
                Collections.reverse(curLevel);
            }
            res.add(curLevel);
            isReverse = !isReverse;

            queue.poll();
            if (!queue.isEmpty()) {
                queue.add(null);
            }
        }
        return res;
    }
}
