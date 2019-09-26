package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q75_SortColors implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public void sortColors(int[] nums) {
        for (int left = 0, right = nums.length - 1, searchPos = 0; searchPos <= right; ) {
            while (left <= right && nums[left] == 0) {
                left++;
            }
            while (left <= right && nums[right] == 2) {
                right--;
            }
            searchPos = left;
            while (searchPos <= right && nums[searchPos] == 1) {
                searchPos++;
            }
            if (searchPos <= right) {
                if (nums[searchPos] == 0) {
                    swap(nums, left, searchPos);
                }
                if (nums[searchPos] == 2) {
                    swap(nums, right, searchPos);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
