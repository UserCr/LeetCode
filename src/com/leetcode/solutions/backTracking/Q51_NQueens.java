package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51_NQueens implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] line : board) {
            Arrays.fill(line, '.');
        }
        int[][] used = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        solveNQueens(board, used, n, 0, res);
        return res;
    }

    private void solveNQueens(char[][] board, int[][] used, int n, int queenNum, List<List<String>> res) {
        if (queenNum == n) {
            List<String> curRes = new ArrayList<>();
            for (char[] line : board) {
                curRes.add(String.valueOf(line));
            }
            res.add(curRes);
        } else {
            for (int i = 0; i < n; ++i) {
                if (0 == used[queenNum][i]) {
                    board[queenNum][i] = 'Q';
                    setUsed(used, queenNum, i, true);
                    solveNQueens(board, used, n, queenNum + 1, res);
                    setUsed(used, queenNum, i, false);
                    board[queenNum][i] = '.';
                }
            }
        }
    }

    private void setUsed(int[][] used, int row, int col, boolean use) {
        for (int i = row; i < used.length; ++i) {
            if (col + i - row < used.length) {
                used[i][col + i - row] = use ? used[i][col + i - row] + 1 : used[i][col + i - row] - 1;
            }
            if (col - (i - row) >= 0) {
                used[i][col - (i - row)] = use ? used[i][col - (i - row)] + 1 : used[i][col - (i - row)] - 1;
            }
            used[i][col] = use ? used[i][col] + 1 : used[i][col] - 1;
        }
    }
}
