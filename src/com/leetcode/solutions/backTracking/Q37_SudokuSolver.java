package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

public class Q37_SudokuSolver implements SolutionInterface {
    @Override
    public void run() {
    }

    class Limit {
        private int[] rowSets = new int[9];
        private int[] colSets = new int[9];
        private int[] gridSets = new int[9];

        public void set(int row, int col, int num) {
            rowSets[row] |= (1 << num);
            colSets[col] |= (1 << num);
            gridSets[whichGrid(row, col)] |= (1 << num);
        }

        public void cancel(int row, int col, int num) {
            rowSets[row] -= (1 << num);
            colSets[col] -= (1 << num);
            gridSets[whichGrid(row, col)] -= (1 << num);
        }

        public boolean notContain(int row, int col, int num) {
            return (rowSets[row] & (1 << num)) == 0 && (colSets[col] & (1 << num)) == 0 &&
                    (gridSets[whichGrid(row, col)] & (1 << num)) == 0;
        }

        private int whichGrid(int row, int col) {
            return (row / 3) * 3 + col / 3;
        }
    }

    //回溯水题。Limit可以用Set实现，也可以用位运算实现，后者效率更高。
    public void solveSudoku(char[][] board) {
        Limit limit = new Limit();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int num = board[row][col] - '0';
                    limit.set(row, col, num);
                }
            }
        }

        int row = 0, col = 0;
        while (row < 9 && board[row][col] != '.') {
            row += (col / 8);
            col = (col + 1) % 9;
        }

        backTracking(board, row, col, limit);
    }

    private boolean backTracking(char[][] board, int row, int col, Limit limit) {
        if (9 == row) {
            return true;
        }

        for (int num = 1; num <= 9; ++num) {
            if (limit.notContain(row, col, num)) {
                limit.set(row, col, num);

                int nextRow = row + col / 8, nextCol = (col + 1) % 9;
                while (nextRow < 9 && board[nextRow][nextCol] != '.') {
                    nextRow += (nextCol / 8);
                    nextCol = (nextCol + 1) % 9;
                }

                boolean res = backTracking(board, nextRow, nextCol, limit);
                if (res) {
                    board[row][col] = (char) ('0' + num);
                    return true;
                }

                limit.cancel(row, col, num);
            }
        }
        return false;
    }
}
