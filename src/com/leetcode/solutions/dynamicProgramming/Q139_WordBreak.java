package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139_WordBreak implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 比较难想到的DP。
     * canBreak[i]含义是s.subString(0, i+1)是否可以break。
     * 若前半部分的串可以break，后半部分的串是wordDict中的一个元素，那么该串显然可以break。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] canBreak = new boolean[s.length()];
        for (int right = 0; right < s.length(); ++right) {
            canBreak[right] = wordSet.contains(s.substring(0, right + 1));
            if (!canBreak[right]) {
                for (int left = 0; left < right; ++left) {
                    if (canBreak[left] && wordSet.contains(s.substring(left + 1, right + 1))) {
                        canBreak[right] = true;
                        break;
                    }
                }
            }
        }
        return canBreak[s.length() - 1];
    }
}
