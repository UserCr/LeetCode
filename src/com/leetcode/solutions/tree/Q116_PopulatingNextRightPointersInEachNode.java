package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.Node;

public class Q116_PopulatingNextRightPointersInEachNode implements SolutionInterface {
    private interface Algorithm {
        Node connect(Node root);
    }

    @Override
    public void run() {
    }

    static class Recursion implements Algorithm {
        //水题。
        @Override
        public Node connect(Node root) {
            if (null == root) {
                return null;
            }

            Node left = root.left, right = root.right;
            while (left != null && right != null) {
                left.next = right;
                left = left.right;
                right = right.left;
            }
            connect(root.left);
            connect(root.right);
            return root;
        }
    }

    static class Iteration implements Algorithm {
        /***
         * 迭代方法有一定难度，要考虑到父节点连接儿子结点的过程中实际将下一层已经全部连接好，所以可以迭代地层序遍历。
         */
        @Override
        public Node connect(Node root) {
            Node curNode = root;
            while (curNode != null && curNode.left != null) {
                Node nextLevelStart = curNode.left;
                while (curNode != null) {
                    curNode.left.next = curNode.right;
                    if (curNode.next != null) {
                        curNode.right.next = curNode.next.left;
                    }
                    curNode = curNode.next;
                }
                curNode = nextLevelStart;
            }
            return root;
        }
    }
}
