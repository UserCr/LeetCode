package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q289_GameOfLife implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (!isDead(board, row, col)) {
                    newBoard[row][col] = 1;
                }
            }
        }
        for (int row = 0; row < board.length; row++) {
            System.arraycopy(newBoard[row], 0, board[row], 0, board[0].length);
        }
    }

    private boolean isDead(int[][] board, int row, int col) {
        int liveCellCount = countLiveCell(board, row, col);
        if (liveCellCount < 2 || liveCellCount > 3) {
            return true;
        } else if (3 == liveCellCount) {
            return false;
        } else {
            return board[row][col] == 0;
        }
    }

    private int countLiveCell(int[][] board, int row, int col) {
        int count = 0;
        final int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] move : moves) {
            int nextRow = row + move[0];
            int nextCol = col + move[1];
            if (0 <= nextRow && nextRow < board.length && 0 <= nextCol && nextCol < board[0].length &&
                    board[nextRow][nextCol] == 1) {
                count++;
            }
        }
        return count;
    }
}
