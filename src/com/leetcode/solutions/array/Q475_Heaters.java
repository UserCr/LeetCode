package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q475_Heaters implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 稍有难度。算法整个思路可以归结为每个房子找到离它最近的那个取暖器，算出距离，所有距离里取最大的。 可以用贪心的策略来提高效率。
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int res = 0;
        int housePos = 0, heaterPos = 0;
        while (housePos < houses.length) {
            while (heaterPos < heaters.length - 1 &&
                    Math.abs(houses[housePos] - heaters[heaterPos]) >= Math.abs(houses[housePos] - heaters[heaterPos + 1])) {
                heaterPos++;
            }
            res = Math.max(res, Math.abs(houses[housePos] - heaters[heaterPos]));
            housePos++;
        }
        return res;
    }
}
