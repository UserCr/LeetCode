package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q35_SearchInsertPosition implements SolutionInterface {
    @Override
    public void run() {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
    }

    //水题。
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
