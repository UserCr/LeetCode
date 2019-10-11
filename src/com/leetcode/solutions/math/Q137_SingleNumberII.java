package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q137_SingleNumberII implements SolutionInterface {
    private interface Algorithm {
        int singleNumber(int[] nums);
    }

    @Override
    public void run() {
    }

    static class BitCount implements Algorithm {
        /***
         * bitCount法。假设大部分属出现k次，一个数出现1次，那么某个比特位上1的总个数必然是“k的倍数+1”。
         * 最终只要用mod运算消去k的倍数，剩下的比特位就是解。
         */
        @Override
        public int singleNumber(int[] nums) {
            final int BIT_WIDTH = 32;
            int[] bitCounts = new int[BIT_WIDTH];
            for (int num : nums) {
                for (int bit = 0; bit < BIT_WIDTH; ++bit) {
                    bitCounts[bit] += (1 & (num >> bit));
                }
            }
            int res = 0;
            for (int bit = 0; bit < BIT_WIDTH; ++bit) {
                res |= ((bitCounts[bit] % 3) << bit);
            }
            return res;
        }
    }

    static class Carry implements Algorithm {
        /***
         * 进制解法和SingleNumber解法思路一致。大部分数字出现k次就是k进制，某比特位累积k次后自动清零，最后剩下来的就是解。
         * 问题的关键在于如何实现k进制算法。一般来说可用ceil(log2(k))位实现k进制，也就是说程序中需要ceil(log2(k))个变量来
         * 保存状态。各变量的计算方法求解难度高，因题而异，一般来说可用真题表做。该通用思路具体可见LeetCode题解。
         * 该题是三进制，相对简单。
         */
        @Override
        public int singleNumber(int[] nums) {
            int ones = 0, twos = 0;
            for (int num : nums) {
                ones = ones ^ num & ~twos;
                twos = twos ^ num & ~ones;
            }
            return ones;
        }
    }
}
