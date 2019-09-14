package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q33_SearchInRotatedSortedArray implements SolutionInterface {
    @Override
    public void run() {
    }

    //二分思路，只需要注意保证查询区间正确。
    public int search(int[] nums, int target) {
        for (int left = 0, right = nums.length - 1; left <= right; ) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                if (nums[right] < nums[mid] || nums[right] > target) {
                    left = mid + 1;
                } else if (nums[right] < target) {
                    right = mid - 1;
                } else {
                    return right;
                }
            } else if (nums[mid] > target) {
                if (nums[left] > nums[mid] || nums[left] < target) {
                    right = mid - 1;
                } else if (nums[left] > target) {
                    left = mid + 1;
                } else {
                    return left;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }
}
