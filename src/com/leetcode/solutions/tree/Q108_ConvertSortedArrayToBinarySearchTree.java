package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

public class Q108_ConvertSortedArrayToBinarySearchTree implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。非递归方法用栈保存当前结点和当前结点的左右下标。
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        } else {
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildTree(nums, left, mid - 1);
            root.right = buildTree(nums, mid + 1, right);
            return root;
        }
    }
}
