package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q154_FindMinimumInRotatedSortedArrayII implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 难点主要在于nums[mid] == nums[right]这种情况，此时无法判断最小值在哪半边，可以通过缩小区间的方法进行迭代。
     * 这里采用 right = right - 1 解决此问题，首先因为 right > left >= 0，所以不会造成数组越界；
     * 其次因为 nums[right] == nums[mid]，所以把 nums[right] 减去后区间中还有一个 nums[mid] 与之相等，不会丢失最小值。
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
