package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q387_FirstUniqueCharacterInAString implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (1 == map.get(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
