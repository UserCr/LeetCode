package com.leetcode.solutions.design;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q208_ImplementTrie_PrefixTree implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。注意可以用HashMap存储子节点，而不是教科书里树的子节点用链表存储。
    static class Trie {
        static class TreeNode {
            char val;
            Map<Character, TreeNode> children = new HashMap<>();

            TreeNode(char val) {
                this.val = val;
            }
        }

        private TreeNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TreeNode((char) 0);
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            word = word + '\0';
            TreeNode curNode = root;
            for (char c : word.toCharArray()) {
                TreeNode childNode = curNode.children.get(c);
                if (null == childNode) {
                    childNode = new TreeNode(c);
                    curNode.children.put(c, childNode);
                }
                curNode = childNode;
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            word = word + '\0';
            return startsWith(word);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TreeNode curNode = root;
            for (char c : prefix.toCharArray()) {
                TreeNode childNode = curNode.children.get(c);
                if (null == childNode) {
                    return false;
                }
                curNode = childNode;
            }
            return true;
        }
    }
}
