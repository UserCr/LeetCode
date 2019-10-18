package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q169_MajorityElement implements SolutionInterface {
    interface Algorithm {
        int majorityElement(int[] nums);
    }

    @Override
    public void run() {
    }

    static class HashMapSolution implements Algorithm {
        //水题，最简单的思路。
        @Override
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int res = 0, maxCount = 0;
            for (int num : nums) {
                int count = map.containsKey(num) ? map.get(num) + 1 : 1;
                map.put(num, count);
                if (count > maxCount) {
                    maxCount = count;
                    res = num;
                }
            }
            return res;
        }
    }

    static class BitMapSolution implements Algorithm {
        //Bit法水题，统计每个bit位1出现得多还是0出现得多。
        @Override
        public int majorityElement(int[] nums) {
            final int BIT_SIZE = 32;
            int[][] bitCount = new int[BIT_SIZE][2];
            for (int num : nums) {
                for (int i = 0; i < BIT_SIZE; ++i) {
                    bitCount[i][(num >> i) & 1]++;
                }
            }
            int res = 0;
            for (int i = 0; i < BIT_SIZE; i++) {
                if (bitCount[i][1] > bitCount[i][0]) {
                    res |= (1 << i);
                }
            }
            return res;
        }
    }

    static class MajorityVote implements Algorithm {
        /***
         * 投票法。核心思路就是每次取到两个不一样的就扔掉，最后剩下来的就是解。
         */
        @Override
        public int majorityElement(int[] nums) {
            int count = 0, curElement = nums[0];
            for (int num : nums) {
                if (0 == count || num == curElement) {
                    if (0 == count) {
                        curElement = num;
                    }
                    count++;
                } else {
                    count--;
                }
            }
            return curElement;
        }
    }
}
