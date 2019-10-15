package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q153_FindMinimumInRotatedSortedArray implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int findMin(int[] nums) {
        for (int left = 0, right = nums.length - 1; left <= right; ) {
            if (nums[left] < nums[right]) {
                return nums[left];
            } else {
                int mid = (left + right) / 2;
                if (left == right || mid > 0 && nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                } else if (nums[left] > nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return 0;
    }
}
