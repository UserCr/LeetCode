package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q290_WordPattern implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。注意模式和串要一一对应。
    public boolean wordPattern(String pattern, String str) {
        String[] parts = str.trim().split(" ");
        Map<Character, String> map = new HashMap<>();

        if (parts.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); ++i) {
            String value = map.get(pattern.charAt(i));
            if (null == value && !map.containsValue(parts[i])) {
                map.put(pattern.charAt(i), parts[i]);
            } else if (null == value || !value.equals(parts[i])) {
                return false;
            }
        }

        return true;
    }
}
