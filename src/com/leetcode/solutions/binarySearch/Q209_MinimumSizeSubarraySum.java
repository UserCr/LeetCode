package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q209_MinimumSizeSubarraySum implements SolutionInterface {
    interface Algorithm {
        int minSubArrayLen(int s, int[] nums);
    }

    @Override
    public void run() {
        int[] nums = {1, 2, 3, 4, 5};
        Algorithm algorithm = new BinarySearch();
        System.out.println(algorithm.minSubArrayLen(15, nums));
    }

    static class TwoArray implements Algorithm {
        //水题。
        @Override
        public int minSubArrayLen(int s, int[] nums) {
            int minLength = 0;
            for (int curSum = 0, left = 0, right = 0; left <= right && right < nums.length; ) {
                while (right < nums.length && curSum < s) {
                    curSum += nums[right++];
                }
                while (left <= right && curSum >= s) {
                    if (0 == minLength) {
                        minLength = right - left;
                    } else {
                        minLength = Math.min(minLength, right - left);
                    }
                    curSum -= nums[left++];
                }
            }
            return minLength;
        }
    }

    static class BinarySearch implements Algorithm {
        //注意数组内的数全部为正数，所以累加和是递增的，这是二分的基础。
        @Override
        public int minSubArrayLen(int s, int[] nums) {
            int[] sum = new int[nums.length + 1];
            for (int i = 1; i < sum.length; ++i) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }

            int res = Integer.MAX_VALUE;
            for (int left = 0; left < sum.length; ++left) {
                int right = binarySearch(sum, sum[left] + s, left + 1);
                if (right >= sum.length) {
                    break;
                }
                res = Math.min(res, right - left);
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }

        private int binarySearch(int[] sum, int s, int left) {
            for (int right = sum.length - 1; left <= right; ) {
                int mid = (left + right) / 2;
                if (sum[mid] >= s) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
