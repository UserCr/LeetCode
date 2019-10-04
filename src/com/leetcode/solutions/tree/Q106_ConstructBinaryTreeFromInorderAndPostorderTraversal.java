package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.HashMap;

public class Q106_ConstructBinaryTreeFromInorderAndPostorderTraversal implements SolutionInterface {
    @Override
    public void run() {
    }

    private HashMap<Integer, Integer> indexMap = new HashMap<>();

    //水题。和根据前序中序建树流程差不多，只不过后序遍历中基准点在右边，而前序遍历的基准点在左边。
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; ++i) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight, int[] inorder, int inLeft, int inRight) {
        if (postLeft == postRight && inLeft == inRight && postorder[postLeft] == inorder[inLeft]) {
            return new TreeNode(postorder[postLeft]);
        } else if (postLeft < postRight && inLeft < inRight) {
            TreeNode root = new TreeNode(postorder[postRight]);
            int rootPosInInorder = indexMap.get(postorder[postRight]);
            int rightStartInPostorder = postRight - (inRight - rootPosInInorder);
            root.left = buildTree(postorder, postLeft, rightStartInPostorder - 1, inorder, inLeft, rootPosInInorder - 1);
            root.right = buildTree(postorder, rightStartInPostorder, postRight - 1, inorder, rootPosInInorder + 1, inRight);
            return root;
        } else {
            return null;
        }
    }
}
