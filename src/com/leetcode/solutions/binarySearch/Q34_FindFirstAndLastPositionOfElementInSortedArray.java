package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q34_FindFirstAndLastPositionOfElementInSortedArray implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。二分思想的应用，不要把二分思想局限于比大小。
    public int[] searchRange(int[] nums, int target) {
        int targetPos = binarySearch(nums, target);
        int[] res = {-1, -1};

        if (-1 == targetPos) {
            return res;
        }

        for (int left = 0, right = targetPos; left <= right; ) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (0 != mid && nums[mid - 1] == target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                res[0] = mid;
                break;
            }
        }
        for (int left = targetPos, right = nums.length - 1; left <= right; ) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if ((nums.length - 1) != mid && nums[mid + 1] == target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                res[1] = mid;
                break;
            }
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        for (int left = 0, right = nums.length - 1; left <= right; ) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
