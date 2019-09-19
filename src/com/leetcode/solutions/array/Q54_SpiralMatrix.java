package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.LinkedList;
import java.util.List;

public class Q54_SpiralMatrix implements SolutionInterface {
    @Override
    public void run() {
    }

    //无聊的水题。
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (0 == matrix.length || 0 == matrix[0].length) {
            return res;
        }

        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        for (int i = 0, j = 0; left <= right && top <= bottom; ) {
            while (j <= right) {
                res.add(matrix[i][j++]);
            }
            top++;
            i++;
            j = right;
            if (top > bottom) {
                break;
            }
            while (i <= bottom) {
                res.add(matrix[i++][j]);
            }
            right--;
            i = bottom;
            j--;
            if (left > right) {
                break;
            }
            while (j >= left) {
                res.add(matrix[i][j--]);
            }
            bottom--;
            i--;
            j = left;
            if (bottom < top) {
                break;
            }
            while (i >= top) {
                res.add(matrix[i--][j]);
            }
            left++;
            i = top;
            j++;
        }
        return res;
    }
}
