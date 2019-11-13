package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q389_FindTheDifference implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。要注意到题目可以转化成若干成对的数中找单独的数问题。
    public char findTheDifference(String s, String t) {
        String string = s + t;
        char[] chars = Arrays.copyOf(string.toCharArray(), string.length());
        char res = 0;
        for (char c : chars) {
            res ^= c;
        }
        return res;
    }
}
