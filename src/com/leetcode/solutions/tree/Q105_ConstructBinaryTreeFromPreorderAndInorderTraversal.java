package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.HashMap;

public class Q105_ConstructBinaryTreeFromPreorderAndInorderTraversal implements SolutionInterface {
    @Override
    public void run() {
    }

    private HashMap<Integer, Integer> indexMap = new HashMap<>();

    //水题。
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; ++i) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft == preRight && inLeft == inRight && preorder[preLeft] == inorder[inLeft]) {
            return new TreeNode(preorder[preLeft]);
        } else if (preLeft < preRight && inLeft < inRight) {
            TreeNode root = new TreeNode(preorder[preLeft]);
            int rootPosInInorder = indexMap.get(preorder[preLeft]);
            int rightStartInPreorder = preLeft + (rootPosInInorder - inLeft) + 1;
            root.left = buildTree(preorder, preLeft + 1, rightStartInPreorder - 1, inorder, inLeft, rootPosInInorder - 1);
            root.right = buildTree(preorder, rightStartInPreorder, preRight, inorder, rootPosInInorder + 1, inRight);
            return root;
        } else {
            return null;
        }
    }
}
