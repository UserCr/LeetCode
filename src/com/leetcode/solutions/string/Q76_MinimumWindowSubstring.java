package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q76_MinimumWindowSubstring implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，整体思路简单，只是左右指针移动条件需要仔细考虑。
    public String minWindow(String s, String t) {
        Map<Character, Integer> curMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = curMap.getOrDefault(c, 0);
            curMap.put(c, count + 1);
        }

        int left = 0, right = 0, finalLeft = 0, finalRight = s.length() + 1;
        while (right < s.length()) {
            while (!rightStop(curMap) && right < s.length()) {
                char c = s.charAt(right++);
                if (curMap.containsKey(c)) {
                    curMap.put(c, curMap.get(c) - 1);
                }
            }
            while (left < right && (!curMap.containsKey(s.charAt(left)) || curMap.get(s.charAt(left)) < 0)) {
                char c = s.charAt(left++);
                if (curMap.containsKey(c)) {
                    curMap.put(c, curMap.get(c) + 1);
                }
            }
            if (!mapHasPositive(curMap) && right - left < finalRight - finalLeft) {
                finalLeft = left;
                finalRight = right;
            }
            if (right < s.length()) {
                curMap.put(s.charAt(left++), 1);
            }
        }
        if (finalRight > s.length()) {
            finalRight = 0;
        }
        return s.substring(finalLeft, finalRight);
    }

    private boolean rightStop(Map<Character, Integer> map) {
        for (int count : map.values()) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean mapHasPositive(Map<Character, Integer> map) {
        for (int count : map.values()) {
            if (count > 0) {
                return true;
            }
        }
        return false;
    }
}
