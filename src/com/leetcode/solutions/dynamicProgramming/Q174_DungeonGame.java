package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q174_DungeonGame implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 有些难度。一般的方格DP都是从左上到右下的，这个要反过来。
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (null == dungeon || 0 == dungeon.length || 0 == dungeon[0].length) {
            return 0;
        }

        int[][] minHP = new int[dungeon.length + 1][dungeon[0].length + 1];
        for (int[] hp : minHP) {
            Arrays.fill(hp, Integer.MAX_VALUE);
        }
        minHP[dungeon.length][dungeon[0].length - 1] = 1;
        minHP[dungeon.length - 1][dungeon[0].length] = 1;

        for (int row = dungeon.length - 1; row >= 0; --row) {
            for (int col = dungeon[0].length - 1; col >= 0; --col) {
                int need = Math.min(minHP[row + 1][col], minHP[row][col + 1]) - dungeon[row][col];
                minHP[row][col] = need <= 0 ? 1 : need;
            }
        }

        return minHP[0][0];
    }
}
