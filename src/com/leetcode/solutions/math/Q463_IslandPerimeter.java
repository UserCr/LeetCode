package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q463_IslandPerimeter implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    res += 4 - hasNeighbourNumber(grid, i, j);
                }
            }
        }
        return res;
    }

    int hasNeighbourNumber(int[][] grid, int i, int j) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        for (int[] move : moves) {
            int row = move[0] + i, col = move[1] + j;
            if (0 <= row && row < grid.length && 0 <= col && col < grid[0].length && grid[row][col] == 1) {
                res++;
            }
        }
        return res;
    }
}
