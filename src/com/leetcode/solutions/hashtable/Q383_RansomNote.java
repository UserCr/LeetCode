package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q383_RansomNote implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            if (0 == count) {
                return false;
            }
            map.put(c, count - 1);
        }
        return true;
    }
}
