package com.leetcode.solutions.dfs;

import com.leetcode.solutions.SolutionInterface;

public class Q200_NumberOfIslands implements SolutionInterface {
    interface Algorithm {
        int numIslands(char[][] grid);
    }

    @Override
    public void run() {
    }

    static class DFS implements Algorithm {
        //水题。
        @Override
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int row, int col) {
            final int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            grid[row][col] = 'v';
            for (int[] move : moves) {
                if (isValid(grid, row + move[0], col + move[1])) {
                    dfs(grid, row + move[0], col + move[1]);
                }
            }
        }

        private boolean isValid(char[][] grid, int row, int col) {
            return 0 <= row && row < grid.length && 0 <= col && col < grid[0].length && grid[row][col] == '1';
        }
    }
}
