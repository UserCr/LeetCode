package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q162_FindPeakElement implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 有些难度，根据中心点和临近点大小关系判断峰在哪边。
     */
    public int findPeakElement(int[] nums) {
        for (int left = 0, right = nums.length - 1; left <= right; ) {
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else if (mid < nums.length - 1 && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
