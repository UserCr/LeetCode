package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q300_LongestIncreasingSubsequence implements SolutionInterface {
    interface Algorithm {
        int lengthOfLIS(int[] nums);
    }

    @Override
    public void run() {
    }

    static class DP implements Algorithm {
        //水题。
        @Override
        public int lengthOfLIS(int[] nums) {
            int[] res = new int[nums.length];
            int maxLength = 0;
            for (int i = 0; i < nums.length; ++i) {
                int beforeMax = 0;
                for (int j = 0; j < i; ++j) {
                    if (nums[j] < nums[i]) {
                        beforeMax = Math.max(beforeMax, res[j]);
                    }
                }
                res[i] = beforeMax + 1;
                maxLength = Math.max(maxLength, res[i]);
            }
            return maxLength;
        }
    }

    static class BinarySearch implements Algorithm {
        /***
         * 非常难想到的算法，主要改进了DP算法中里循环确定dp[i]的效率，从O(n)降到了O(logN)。
         * tails[i]是长度为i+1的子序列集合中最小的末尾元素，比如序列1，5，3，2，4中，tails[0]=1,tails[1]=2，以此类推。
         * 状态转移方程可以这么理解：若当前元素是第i个元素，之前的i-1个元素已有长度从1到k(k <= i-1)的若干子序列（末尾元素尽可能小），
         * 第i个元素要么单独成为长度为1的序列，要么接在前k个子序列之后组成新序列，若新序列长度在2到k之间，必然存在两个序列长度一致的
         * 序列，选择末尾元素最小的那个留下。
         * 具体实现时，可以略去一些不必要的步骤，直接维护各序列最末元素即可。
         */
        @Override
        public int lengthOfLIS(int[] nums) {
            if (null == nums || 0 == nums.length) {
                return 0;
            }

            int[] tails = new int[nums.length];
            tails[0] = nums[0];
            int tailsSize = 1;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] < tails[0]) {
                    tails[0] = nums[i];
                } else if (nums[i] > tails[tailsSize - 1]) {
                    tails[tailsSize++] = nums[i];
                } else {
                    int left = 0;
                    for (int right = tailsSize - 1; left <= right; ) {
                        int mid = (left + right) / 2;
                        if (tails[mid] > nums[i] && (0 == mid || tails[mid - 1] < nums[i])) {
                            tails[mid] = nums[i];
                        } else if (tails[mid] > nums[i]) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }
                }
            }
            return tailsSize;
        }
    }
}
