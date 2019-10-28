package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257_BinaryTreePaths implements SolutionInterface {
    @Override
    public void run() {
    }

    private List<String> path = new ArrayList<>();
    private List<String> res = new ArrayList<>();

    //水题。
    public List<String> binaryTreePaths(TreeNode root) {
        if (null != root) {
            preOrderTraversal(root);
        }
        return res;
    }

    private void preOrderTraversal(TreeNode root) {
        path.add(Integer.toString(root.val));
        if (null == root.left && null == root.right) {
            res.add(String.join("->", path));
        }

        if (null != root.left) {
            preOrderTraversal(root.left);
        }
        if (null != root.right) {
            preOrderTraversal(root.right);
        }
        path.remove(path.size() - 1);
    }
}
