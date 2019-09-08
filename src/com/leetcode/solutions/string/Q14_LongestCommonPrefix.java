package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q14_LongestCommonPrefix implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int shortestStringLength = strs[0].length();
        for (String str : strs) {
            if (shortestStringLength > str.length()) {
                shortestStringLength = str.length();
            }
        }
        for (int pos = 0; pos < shortestStringLength; ++pos) {
            char curChar = strs[0].charAt(pos);
            for (int i = 1; i < strs.length; ++i) {
                if (strs[i].charAt(pos) != curChar) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(curChar);
        }
        return stringBuilder.toString();
    }
}
