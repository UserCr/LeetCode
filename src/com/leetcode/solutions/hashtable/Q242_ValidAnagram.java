package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q242_ValidAnagram implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charCounter = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCounter.merge(c, 1, Integer::sum);
        }
        for (char c : t.toCharArray()) {
            Integer count = charCounter.get(c);
            if (null == count) {
                return false;
            } else {
                charCounter.put(c, count - 1);
            }
        }
        for (char c : charCounter.keySet()) {
            if (charCounter.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
