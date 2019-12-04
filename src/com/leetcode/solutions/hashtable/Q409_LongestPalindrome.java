package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;

public class Q409_LongestPalindrome implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        boolean hasSingle = false;
        for (char c : map.keySet()) {
            int count = map.get(c);
            res += (count / 2) * 2;
            if (!hasSingle && count % 2 == 1) {
                hasSingle = true;
            }
        }
        if (hasSingle) {
            res++;
        }
        return res;
    }
}
