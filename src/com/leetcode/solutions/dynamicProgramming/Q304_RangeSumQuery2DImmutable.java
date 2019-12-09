package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q304_RangeSumQuery2DImmutable implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    class NumMatrix {
        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
                return;
            }
            sum = new int[matrix.length][matrix[0].length];
            sum[0][0] = matrix[0][0];
            for (int i = 1; i < matrix.length; ++i) {
                sum[i][0] = sum[i - 1][0] + matrix[i][0];
            }
            for (int i = 1; i < matrix[0].length; ++i) {
                sum[0][i] = sum[0][i - 1] + matrix[0][i];
            }
            for (int i = 1; i < matrix.length; ++i) {
                for (int j = 1; j < matrix[0].length; ++j) {
                    sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (null == sum) {
                return 0;
            }
            int res = sum[row2][col2];
            if (row1 - 1 >= 0) {
                res -= sum[row1 - 1][col2];
            }
            if (col1 - 1 >= 0) {
                res -= sum[row2][col1 - 1];
            }
            if (row1 - 1 >= 0 && col1 - 1 >= 0) {
                res += sum[row1 - 1][col1 - 1];
            }
            return res;
        }
    }
}
