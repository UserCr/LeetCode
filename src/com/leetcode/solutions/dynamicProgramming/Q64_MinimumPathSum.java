package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q64_MinimumPathSum implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，要特别留意第一行的初始化数值。
    public int minPathSum(int[][] grid) {
        if (0 == grid.length || 0 == grid[0].length) {
            return 0;
        }

        int[] lastRes = new int[grid[0].length], curRes = new int[grid[0].length];
        Arrays.fill(lastRes, Integer.MAX_VALUE);
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (0 == j) {
                    curRes[j] = lastRes[j] + grid[i][j];
                } else {
                    curRes[j] = Math.min(curRes[j - 1], lastRes[j]) + grid[i][j];
                }
            }
            if (grid.length - 1 != i) {
                int[] temp = curRes;
                curRes = lastRes;
                lastRes = temp;
            }
        }
        return curRes[curRes.length - 1];
    }

}
