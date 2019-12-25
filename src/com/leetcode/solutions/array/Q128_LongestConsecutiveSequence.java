package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;

public class Q128_LongestConsecutiveSequence implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 水题。map中value是key所在连续序列的长度。题目关键在于map中连续序列的中间部分的value不必维护（因为新的key不可能出现在中间），
     * 因此只要维护序列两个端点处的值就行，而已知一个端点的key和value是可以求出另一个端点的key的。
     */
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                int left = hashMap.getOrDefault(num - 1, 0);
                int right = hashMap.getOrDefault(num + 1, 0);

                int length = left + right + 1;
                res = Math.max(res, length);
                hashMap.put(num, length);
                if (left != 0) {
                    hashMap.put(num - left, length);
                }
                if (right != 0) {
                    hashMap.put(num + right, length);
                }
            }
        }
        return res;
    }
}
