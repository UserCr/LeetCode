package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q167_TwoSumIIInputArrayIsSorted implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。该题用二分的话时间复杂度是O(NlogN)。
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {0, numbers.length - 1};
        while (res[0] < res[1] && numbers[res[0]] + numbers[res[1]] != target) {
            if (numbers[res[0]] + numbers[res[1]] < target) {
                res[0]++;
            } else {
                res[1]--;
            }
        }
        res[0]++;
        res[1]++;
        return res;
    }
}
