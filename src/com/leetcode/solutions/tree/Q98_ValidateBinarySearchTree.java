package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.Stack;

public class Q98_ValidateBinarySearchTree implements SolutionInterface {
    interface Algorithm {
        boolean isValidBST(TreeNode root);
    }

    @Override
    public void run() {
    }

    private static class Recursion implements Algorithm {
        /***
         * 此题有难度，乍一看容易想成只判断左中右三个结点大小关系的解法，但这种解法是有缺陷的，比如根节点是5，右子树根节点是6，
         * 右子树左儿子是4这种情况按这种解法判断就会出错。实际上题目要求整个左（右）子树中的结点都要小（大）于根结点，这就隐含地
         * 加入了结点值是否在合法上下界内的条件，因此应当在题解中加入对该条件的判断。
         */
        @Override
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        private boolean helper(TreeNode root, Integer min, Integer max) {
            if (null == root) {
                return true;
            }
            if ((null != min && root.val <= min) || (null != max && root.val >= max)) {
                return false;
            }
            if ((root.left != null && root.left.val >= root.val) || (root.right != null && root.right.val <= root.val)) {
                return false;
            }
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }
    }

    private static class InOrderNotRecursion implements Algorithm {
        //二叉搜索树必须满足中序遍历递增的性质,题解用的是非递归写法。
        @Override
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curNode = root;
            Integer preValue = null;
            while (!stack.isEmpty() || curNode != null) {
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                }
                curNode = stack.pop();
                if (null == preValue) {
                    preValue = curNode.val;
                } else if (preValue >= curNode.val) {
                    return false;
                } else {
                    preValue = curNode.val;
                }
                curNode = curNode.right;
            }
            return true;
        }
    }

    private static class InOrderRecursion implements Algorithm {
        //二叉搜索树必须满足中序遍历递增的性质,题解用的是递归写法。
        private Integer preValue = null;

        @Override
        public boolean isValidBST(TreeNode root) {
            if (null == root) {
                return true;
            }
            if (!isValidBST(root.left)) {
                return false;
            }
            if (null == preValue || preValue < root.val) {
                preValue = root.val;
            } else {
                return false;
            }

            return isValidBST(root.right);
        }
    }
}
