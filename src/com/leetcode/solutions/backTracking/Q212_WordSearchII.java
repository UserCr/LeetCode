package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q212_WordSearchII implements SolutionInterface {
    @Override
    public void run() {
    }

    static class TrieTreeNode {
        TrieTreeNode[] next = new TrieTreeNode[26];
        String word;
    }

    /***
     * 普通回溯非常简单，难点在于如何利用字典树进行剪枝。答案十分巧妙，直接遍历board中每个元素为起点所能构成的单词。
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        if (null == board || 0 == board.length || 0 == board[0].length) {
            return res;
        }

        TrieTreeNode root = buildTrieTree(words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                backTracking(board, visited, i, j, root, res);
            }
        }
        return res;
    }

    private void backTracking(char[][] board, boolean[][] visited, int i, int j, TrieTreeNode p, List<String> res) {
        char c = board[i][j];
        if (visited[i][j] || null == p.next[c - 'a']) {
            return;
        }
        p = p.next[c - 'a'];
        if (null != p.word) {
            res.add(p.word);
            p.word = null;
        }

        visited[i][j] = true;
        if (i > 0) {
            backTracking(board, visited, i - 1, j, p, res);
        }
        if (j > 0) {
            backTracking(board, visited, i, j - 1, p, res);
        }
        if (i < board.length - 1) {
            backTracking(board, visited, i + 1, j, p, res);
        }
        if (j < board[0].length - 1) {
            backTracking(board, visited, i, j + 1, p, res);
        }
        visited[i][j] = false;
    }

    private TrieTreeNode buildTrieTree(String[] words) {
        TrieTreeNode root = new TrieTreeNode();
        for (String word : words) {
            TrieTreeNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (null == p.next[i]) {
                    p.next[i] = new TrieTreeNode();
                }
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }
}
