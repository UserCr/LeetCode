package com.leetcode.solutions.dfs;

import com.leetcode.solutions.SolutionInterface;

public class Q130_SurroundedRegions implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public void solve(char[][] board) {
        if (0 == board.length || 0 == board[0].length) {
            return;
        }
        for (int col = 0; col < board[0].length; ++col) {
            if ('O' == board[0][col]) {
                dfs(board, 0, col);
            }
            if ('O' == board[board.length - 1][col]) {
                dfs(board, board.length - 1, col);
            }
        }
        for (int row = 0; row < board.length; ++row) {
            if ('O' == board[row][0]) {
                dfs(board, row, 0);
            }
            if ('O' == board[row][board[0].length - 1]) {
                dfs(board, row, board[0].length - 1);
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if ('O' == board[i][j]) {
                    board[i][j] = 'X';
                } else if ('1' == board[i][j]) {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int[][] moves = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        board[i][j] = '1';
        for (int[] move : moves) {
            int row = i + move[0], col = j + move[1];
            if (isValidPos(board, row, col) && board[row][col] == 'O') {
                dfs(board, row, col);
            }
        }
    }

    private boolean isValidPos(char[][] board, int i, int j) {
        return 0 <= i && i < board.length && 0 <= j && j < board[0].length;
    }
}
