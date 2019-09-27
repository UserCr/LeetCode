package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

public class Q79_WordSearch implements SolutionInterface {
    @Override
    public void run() {
    }

    private static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    //DFS水题，因为基本还是简单的回溯，所以归到回溯类。
    public boolean exist(char[][] board, String word) {
        if (0 == board.length || 0 == board[0].length) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    boolean res = backTracking(board, visited, word, 1, i, j);
                    visited[i][j] = false;
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backTracking(char[][] board, boolean[][] visited, String word, int curCharPos, int curRow, int curCol) {
        visited[curRow][curCol] = true;
        if (word.length() == curCharPos) {
            return true;
        } else {
            boolean res = false;
            final char curChar = word.charAt(curCharPos);
            for (int[] move : moves) {
                if (posIsValid(board, visited, curRow + move[0], curCol + move[1], curChar)) {
                    res = backTracking(board, visited, word, curCharPos + 1, curRow + move[0], curCol + move[1]);
                }
                if (res) {
                    return true;
                }
            }
            visited[curRow][curCol] = false;
            return false;
        }
    }

    private boolean posIsValid(char[][] board, boolean[][] visited, int i, int j, char curChar) {
        return 0 <= i && i < board.length && 0 <= j && j < board[0].length && !visited[i][j] && curChar == board[i][j];
    }
}
