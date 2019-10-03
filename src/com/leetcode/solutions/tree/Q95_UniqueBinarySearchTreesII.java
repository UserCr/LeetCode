package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q95_UniqueBinarySearchTreesII implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 有些难度的DP题目。难点不在DP部分，DP状态转移方程非常简单，具体可以看此题简化版“UniqueBinarySearchTrees”的题解。
     * 此题难点主要在于左右子树的复制生成时要保证序号符合要求,不能左右子树序号都从1开始。
     * 此题解的DP过程可以保证中间解序号都是从1开始（可用递推法证明），那么只需要右子树序号通通加上左子树和根的节点数偏移即可。
     */

    public List<TreeNode> generateTrees(int n) {
        if (0 == n) {
            return new LinkedList<>();
        }

        List<List<TreeNode>> roots = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; ++i) {
            roots.add(new LinkedList<>());
        }
        roots.get(0).add(null);
        for (int i = 1; i <= n; ++i) {
            for (int leftNum = 0; leftNum <= i - 1; ++leftNum) {
                List<TreeNode> leftTrees = roots.get(leftNum);
                List<TreeNode> rightTrees = roots.get(i - 1 - leftNum);
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(leftNum + 1);
                        root.left = clone(leftTree, 0);
                        root.right = clone(rightTree, leftNum + 1);
                        roots.get(i).add(root);
                    }
                }
            }
        }
        return roots.get(n);
    }

    static private TreeNode clone(TreeNode root, int offset) {
        if (null == root) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val + offset);
        newRoot.left = clone(root.left, offset);
        newRoot.right = clone(root.right, offset);
        return newRoot;
    }
}
