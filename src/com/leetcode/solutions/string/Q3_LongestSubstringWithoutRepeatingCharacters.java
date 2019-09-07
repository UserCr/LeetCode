package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;

public class Q3_LongestSubstringWithoutRepeatingCharacters implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，只需要注意审题，题目要求的是子串内字符不重复即可。

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (null == s || s.isEmpty()) return 0;
            int subStringLength = 0, curLength = 0;
            int right = 0, left = 0;
            HashMap<Character, Integer> hashMap = new HashMap<>(s.length());
            while (right < s.length()) {
                if (!hashMap.containsKey(s.charAt(right))) {
                    hashMap.put(s.charAt(right), right);
                    right++;
                    curLength++;
                    if (curLength > subStringLength) {
                        subStringLength = curLength;
                    }
                } else {
                    while (s.charAt(left) != s.charAt(right)) {
                        hashMap.remove(s.charAt(left));
                        left++;
                        curLength--;
                    }
                    hashMap.remove(s.charAt(left));
                    left++;
                    curLength--;
                }
            }
            return subStringLength;
        }
    }
}
