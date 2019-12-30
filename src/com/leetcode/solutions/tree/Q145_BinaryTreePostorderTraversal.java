package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q145_BinaryTreePostorderTraversal implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 二叉树后序非递归遍历，必须掌握。后序非递归遍历有很多种写法，题解这种是最接近前序中序经典非递归写法的，必须记住。
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode = null, curNode = root;
        while (!stack.isEmpty() || null != curNode) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.peek();
            if (null != curNode.right && prevNode != curNode.right) {
                curNode = curNode.right;
            } else {
                res.add(curNode.val);

                stack.pop();
                prevNode = curNode;
                curNode = null;
            }
        }
        return res;
    }
}
