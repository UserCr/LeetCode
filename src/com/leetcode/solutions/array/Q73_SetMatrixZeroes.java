package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q73_SetMatrixZeroes implements SolutionInterface {
    @Override
    public void run() {
    }

    //略水。注意O(1)空间复杂度有一定难度，比较容易想到的是O(m+n)空间复杂度，实际上可以用数据第一行或第一列元素来存储是否改零的状态。
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColumnZero = false;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (0 == matrix[i][j]) {
                    if (0 == i) {
                        firstRowZero = true;
                    }
                    if (0 == j) {
                        firstColumnZero = true;
                    }
                    if (i > 0 && j > 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        for (int row = 1; row < matrix.length; ++row) {
            if (0 == matrix[row][0]) {
                for (int col = 1; col < matrix[0].length; ++col) {
                    matrix[row][col] = 0;
                }
            }
        }
        for (int col = 1; col < matrix[0].length; ++col) {
            if (0 == matrix[0][col]) {
                for (int row = 1; row < matrix.length; ++row) {
                    matrix[row][col] = 0;
                }
            }
        }
        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; ++i) {
                matrix[0][i] = 0;
            }
        }
        if (firstColumnZero) {
            for (int j = 0; j < matrix.length; ++j) {
                matrix[j][0] = 0;
            }
        }
    }
}
