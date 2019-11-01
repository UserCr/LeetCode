package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q222_CountCompleteTreeNodes implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * O(n)算法十分简单，递归即可，但是它没有利用完全二叉树的性质。
     * O(logNLogN）算法有些难度。该算法利用了完全二叉树左右子树中至少有一个满二叉树的性质，而满二叉树的结点数可以直接计算得出，
     * 省去了不必要的遍历。
     * 判定左右子树哪个是满二叉树有一点难度。判断方法是看右子树的最左下结点是否在叶子层。
     */
    public int countNodes(TreeNode root) {
        int rootLeftDepth = leftDepth(root);
        if (0 == rootLeftDepth) {
            return 0;
        }

        int rightLeftDepth = leftDepth(root.right);
        if (rightLeftDepth == rootLeftDepth - 1) {
            //最底层叶子有右子树的结点，说明左子树是满二叉树，右子树可能是满二叉树
            return 1 + (1 << (rootLeftDepth - 1)) - 1 + countNodes(root.right);
        } else {
            //最底层叶子没有右子树结点，说明左子树可能是满二叉树，右子树是一个满二叉树
            return 1 + (1 << (rootLeftDepth - 2)) - 1 + countNodes(root.left);
        }
    }

    private int leftDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}
