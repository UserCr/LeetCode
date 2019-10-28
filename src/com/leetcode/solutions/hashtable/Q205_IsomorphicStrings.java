package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q205_IsomorphicStrings implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。注意Map中的value也不能重复。
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            Character mapChar = hashMap.get(sChar);
            if (null != mapChar && mapChar != tChar ||
                    null == mapChar && hashMap.containsValue(tChar)) {
                return false;
            } else if (null == mapChar) {
                hashMap.put(sChar, tChar);
            }
        }
        return true;
    }
}
