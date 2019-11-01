package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q221_MaximalSquare implements SolutionInterface {
    @Override
    public void run() {
    }

    //有些难度的水题，可能不太容易想到是DP题目。
    public int maximalSquare(char[][] matrix) {
        if (0 == matrix.length || 0 == matrix[0].length) {
            return 0;
        }

        int[][] square = new int[matrix.length][matrix[0].length];
        for (int col = 0; col < matrix[0].length; ++col) {
            square[0][col] = matrix[0][col] == '1' ? 1 : 0;
        }
        for (int row = 0; row < matrix.length; ++row) {
            square[row][0] = matrix[row][0] == '1' ? 1 : 0;
        }

        int maxSquare = 0;
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[0].length; ++col) {
                if (row > 0 && col > 0) {
                    if (matrix[row][col] == '0') {
                        square[row][col] = 0;
                    } else {
                        square[row][col] = 1 + Math.min(Math.min(square[row - 1][col], square[row][col - 1]),
                                square[row - 1][col - 1]);
                    }
                }
                maxSquare = Math.max(maxSquare, square[row][col]);
            }
        }

        return maxSquare * maxSquare;
    }
}
