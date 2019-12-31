package com.leetcode.solutions.sort;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q164_MaximumGap implements SolutionInterface {
    @Override
    public void run() {
    }

    //基数排序，必须掌握。
    public int maximumGap(int[] nums) {
        int[] sortNums = bucketSort(nums);
        int gap = 0;
        for (int i = 1; i < sortNums.length; ++i) {
            gap = Math.max(gap, sortNums[i] - sortNums[i - 1]);
        }
        return gap;
    }

    private int[] bucketSort(int[] nums) {
        int[] res = Arrays.copyOf(nums, nums.length);
        int[] oneNums = new int[nums.length];
        int[] zeroNums = new int[nums.length];

        for (int i = 0; i < 32; ++i) {
            int needle = 1 << i;
            int onePos = 0, zeroPos = 0;
            for (int num : res) {
                if ((num & needle) == 0) {
                    zeroNums[zeroPos++] = num;
                } else {
                    oneNums[onePos++] = num;
                }
            }
            fillArray(res, 0, zeroNums, zeroPos);
            fillArray(res, zeroPos, oneNums, onePos);
        }

        return res;
    }

    private void fillArray(int[] toFill, int startFillPos, int[] original, int length) {
        for (int i = 0; i < length; ++i) {
            toFill[startFillPos++] = original[i];
        }
    }
}
