package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

public class Q52_NQueensII implements SolutionInterface {
    @Override
    public void run() {
    }

    private int res = 0;

    //水题。
    public int totalNQueens(int n) {
        int[][] used = new int[n][n];
        solveNQueens(used, n, 0);
        return res;
    }

    private void solveNQueens(int[][] used, int n, int queenNum) {
        if (queenNum == n) {
            res++;
        } else {
            for (int i = 0; i < n; ++i) {
                if (0 == used[queenNum][i]) {
                    setUsed(used, queenNum, i, true);
                    solveNQueens(used, n, queenNum + 1);
                    setUsed(used, queenNum, i, false);
                }
            }
        }
    }

    private void setUsed(int[][] used, int row, int col, boolean use) {
        for (int i = row; i < used.length; ++i) {
            int left = col - (i - row), right = col + i - row;
            if (use) {
                if (right < used.length) {
                    used[i][col + i - row]++;
                }
                if (left >= 0) {
                    used[i][col - (i - row)]++;
                }
                used[i][col]++;
            } else {
                if (right < used.length) {
                    used[i][col + i - row]--;
                }
                if (left >= 0) {
                    used[i][col - (i - row)]--;
                }
                used[i][col]--;
            }
        }
    }
}
