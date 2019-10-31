package com.leetcode.solutions.design;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q211_AddAndSearchWord_DataStructureDesign implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    static class WordDictionary {

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
        public WordDictionary() {
            root = new TreeNode((char) 0);
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
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
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            word = "." + word + '\0';
            return search(root, word, 0);
        }

        private boolean search(TreeNode curNode, String word, int index) {
            char c = word.charAt(index);

            if (index == word.length() - 1 && curNode.val == c) {
                return true;
            }

            if (word.charAt(index) != '.' && curNode.val != c) {
                return false;
            }

            if (word.charAt(index + 1) != '.') {
                TreeNode child = curNode.children.get(word.charAt(index + 1));
                if (null == child) {
                    return false;
                } else {
                    return search(child, word, index + 1);
                }
            } else {
                for (TreeNode child : curNode.children.values()) {
                    if (search(child, word, index + 1)) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
