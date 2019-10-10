package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.tree.Node;

public class Q117_PopulatingNextRightPointersInEachNodeII implements SolutionInterface {
    private interface Algorithm {
        Node connect(Node root);
    }

    @Override
    public void run() {
    }

    static class Recursion implements Algorithm {
        /***
         * 有些难度，关键在于右边的部分要先于左边的部分先完成连接，否则左边某些结点找不到兄弟。
         */
        @Override
        public Node connect(Node root) {
            if (null == root) {
                return null;
            }

            if (root.left != null) {
                root.left.next = nextSibling(root, root.left);
            }
            if (root.right != null) {
                root.right.next = nextSibling(root, root.right);
            }

            connect(root.right);
            connect(root.left);
            return root;
        }

        private Node nextSibling(Node root, Node child) {
            if (child == root.left && root.right != null) {
                return root.right;
            } else {
                root = root.next;
                while (root != null) {
                    if (root.left != null) {
                        return root.left;
                    } else if (root.right != null) {
                        return root.right;
                    }
                    root = root.next;
                }
                return null;
            }
        }
    }

    static class Iteration implements Algorithm {
        /***
         * "PopulatingNextRightPointersInEachNode"改进题，思路相近，不过要注意每层起始点和兄弟结点是需要寻找的，
         * 不可以简单地认为是当前结点的儿子或是兄弟儿子。
         */
        @Override
        public Node connect(Node root) {
            Node curNode = root;
            while (curNode != null) {
                Node nextStart = nextLevelStart(curNode);
                while (curNode != null) {
                    if (curNode.left != null) {
                        curNode.left.next = nextSibling(curNode, curNode.left);
                    }
                    if (curNode.right != null) {
                        curNode.right.next = nextSibling(curNode, curNode.right);
                    }
                    curNode = curNode.next;
                }
                curNode = nextStart;
            }
            return root;
        }

        private Node nextLevelStart(Node start) {
            Node nextStartParent = start, nextLevelStart = null;
            while (nextStartParent != null) {
                if (nextStartParent.left != null) {
                    nextLevelStart = nextStartParent.left;
                    break;
                } else if (nextStartParent.right != null) {
                    nextLevelStart = nextStartParent.right;
                    break;
                }
                nextStartParent = nextStartParent.next;
            }
            return nextLevelStart;
        }

        private Node nextSibling(Node root, Node child) {
            if (child == root.left && root.right != null) {
                return root.right;
            } else {
                root = root.next;
                while (root != null) {
                    if (root.left != null) {
                        return root.left;
                    } else if (root.right != null) {
                        return root.right;
                    }
                    root = root.next;
                }
                return null;
            }
        }
    }
}
