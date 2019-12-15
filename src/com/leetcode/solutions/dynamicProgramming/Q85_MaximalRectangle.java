package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;
import java.util.Stack;

public class Q85_MaximalRectangle implements SolutionInterface {
    interface Algorithm {
        int maximalRectangle(char[][] matrix);
    }

    @Override
    public void run() {
    }

    static class DP_Stack implements Algorithm {
        //水题。先将每行在竖直方向上的连续1个数统计出来，问题就转化成了直方图求最大矩阵面积问题(详见Q84)。
        @Override
        public int maximalRectangle(char[][] matrix) {
            if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
                return 0;
            }

            int[][] rowHeights = new int[matrix.length][matrix[0].length];
            for (int col = 0; col < matrix[0].length; ++col) {
                int count = 0;
                for (int row = matrix.length - 1; row >= 0; --row) {
                    if (matrix[row][col] == '1') {
                        count++;
                    } else {
                        count = 0;
                    }
                    rowHeights[row][col] = count;
                }
            }

            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            for (int[] heights : rowHeights) {
                stack.push(-1);
                for (int i = 0; i < heights.length; ++i) {
                    while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                        int height = heights[stack.pop()];
                        maxArea = Math.max(maxArea, height * (i - stack.peek() - 1));
                    }
                    stack.push(i);
                }
                while (stack.peek() != -1) {
                    int height = heights[stack.pop()];
                    maxArea = Math.max(maxArea, height * (heights.length - stack.peek() - 1));
                }
            }
            return maxArea;
        }
    }

    static class DP implements Algorithm {
        /***
         * 纯DP方法稍有难度。由row数组中的第i个元素扩展出的最大矩形记为A，数组h矩形A的高，数组l维护A左边的坐标，r维护A右边的坐标。
         * 因为A是由上向下逐渐遍历的，所以宽度可能会变窄，所以l要选出最靠右的值，r要选出最靠左的值。
         */
        @Override
        public int maximalRectangle(char[][] matrix) {
            if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
                return 0;
            }

            final int LENGTH = matrix[0].length;

            int maxArea = 0;
            int[] l = new int[LENGTH];
            int[] r = new int[LENGTH];
            int[] h = new int[LENGTH];

            Arrays.fill(r, LENGTH);
            for (char[] row : matrix) {
                int curLeft = 0;
                for (int i = 0; i < LENGTH; ++i) {
                    if (row[i] == '1') {
                        h[i]++;

                        l[i] = Math.max(l[i], curLeft);
                    } else {
                        h[i] = 0;

                        curLeft = i + 1;
                        l[i] = 0;
                    }
                }
                int curRight = LENGTH - 1;
                for (int i = LENGTH - 1; i >= 0; --i) {
                    if (row[i] == '1') {
                        r[i] = Math.min(r[i], curRight);
                    } else {
                        curRight = i - 1;
                        r[i] = LENGTH - 1;
                    }
                }

                for (int i = 0; i < LENGTH; ++i) {
                    maxArea = Math.max(maxArea, h[i] * (r[i] - l[i] + 1));
                }
            }

            return maxArea;
        }
    }
}
