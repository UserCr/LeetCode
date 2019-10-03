package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q94_BinaryTreeInorderTraversal implements SolutionInterface {
    @Override
    public void run() {
    }

    //二叉树中序非递归遍历，必须掌握。
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (!stack.isEmpty() || null != curNode) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            res.add(curNode.val);
            curNode = curNode.right;
        }
        return res;
    }
}
