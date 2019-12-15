package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q87_ScrambleString implements SolutionInterface {
    @Override
    public void run() {
    }

    //无聊的题目，死记硬背即可。
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        final int LENGTH = s1.length();

        int[] counts = new int[256];
        for (int i = 0; i < LENGTH; ++i) {
            counts[s1.charAt(i)]++;
            counts[s2.charAt(i)]--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        if (LENGTH <= 3) {
            return true;
        }

        for (int i = 1; i < LENGTH; ++i) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(LENGTH - i)) && isScramble(s1.substring(i), s2.substring(0, LENGTH - i))) {
                return true;
            }
        }

        return false;
    }
}
