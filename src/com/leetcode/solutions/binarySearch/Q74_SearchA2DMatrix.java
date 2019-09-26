package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q74_SearchA2DMatrix implements SolutionInterface {
    @Override
    public void run() {
    }

    //二分水题。
    public boolean searchMatrix(int[][] matrix, int target) {
        if (0 == matrix.length || 0 == matrix[0].length) {
            return false;
        }

        int row = 0;
        for (int top = 0, bottom = matrix.length - 1; top <= bottom; ) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else {
                if (matrix[mid][0] == target) {
                    return true;
                } else if (mid == matrix.length - 1 || matrix[mid + 1][0] > target) {
                    row = mid;
                    break;
                } else {
                    top = mid + 1;
                }
            }
        }
        for (int left = 0, right = matrix[row].length - 1; left <= right; ) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] > target) {
                right = mid - 1;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
