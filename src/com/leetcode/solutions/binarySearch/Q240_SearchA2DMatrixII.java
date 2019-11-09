package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q240_SearchA2DMatrixII implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 经典题目，关键要找搜索矩阵的左下角或右上角作为基准，只有这两个点可以通过调整所在行列进行增减。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
            return false;
        }
        for (int row = matrix.length - 1, col = 0; 0 <= row && col < matrix[0].length; ) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
