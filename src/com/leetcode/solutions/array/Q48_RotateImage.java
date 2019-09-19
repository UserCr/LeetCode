package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q48_RotateImage implements SolutionInterface {
    @Override
    public void run() {
    }

    //稍麻烦的水题，仔细分析一下就可以求解。
    public void rotate(int[][] matrix) {
        for (int row = 0; row < matrix.length / 2; ++row) {
            for (int column = row; column < matrix.length - 1 - row; ++column) {
                int temp = matrix[row][column];
                matrix[row][column] = matrix[matrix.length - 1 - column][row];
                matrix[matrix.length - 1 - column][row] = matrix[matrix.length - 1 - row][matrix.length - 1 - column];
                matrix[matrix.length - 1 - row][matrix.length - 1 - column] = matrix[column][matrix.length - 1 - row];
                matrix[column][matrix.length - 1 - row] = temp;
            }
        }
    }
}
