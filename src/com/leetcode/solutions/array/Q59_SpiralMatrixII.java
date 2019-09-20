package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q59_SpiralMatrixII implements SolutionInterface {
    @Override
    public void run() {
    }

    //无聊水题。
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1, curValue = 1;
        for (int i = 0, j = 0; left <= right && top <= bottom; ) {
            while (j <= right) {
                res[i][j++] = curValue++;
            }
            top++;
            i++;
            j = right;
            if (top > bottom) {
                break;
            }
            while (i <= bottom) {
                res[i++][j] = curValue++;
            }
            right--;
            i = bottom;
            j--;
            if (left > right) {
                break;
            }
            while (j >= left) {
                res[i][j--] = curValue++;
            }
            bottom--;
            i--;
            j = left;
            if (bottom < top) {
                break;
            }
            while (i >= top) {
                res[i--][j] = curValue++;
            }
            left++;
            i = top;
            j++;
        }
        return res;
    }
}
