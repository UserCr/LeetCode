package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q63_UniquePathsII implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，注意加入障碍后第一列通行方式不再固定为1了，而是等于上一行第一列的值。另外这么修改后，lastRes的初始值要单独做一些处理。
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (0 == obstacleGrid.length || 0 == obstacleGrid[0].length) {
            return 0;
        }

        int[] lastRes = new int[obstacleGrid[0].length], curRes = new int[obstacleGrid[0].length];
        lastRes[0] = 1;
        for (int i = 0; i < obstacleGrid.length; ++i) {
            for (int j = 0; j < obstacleGrid[0].length; ++j) {
                if (1 == obstacleGrid[i][j]) {
                    curRes[j] = 0;
                } else {
                    if (0 == j) {
                        curRes[j] = lastRes[j];
                    } else {
                        curRes[j] = curRes[j - 1] + lastRes[j];
                    }
                }
            }
            if (obstacleGrid.length - 1 != i) {
                int[] temp = curRes;
                curRes = lastRes;
                lastRes = temp;
            }
        }
        return curRes[curRes.length - 1];
    }
}
